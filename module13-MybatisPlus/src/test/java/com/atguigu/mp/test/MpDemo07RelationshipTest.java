package com.atguigu.mp.test;

import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.entity.EmpRoleInner;
import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.entity.SysRole;
import com.atguigu.mp.service.api.DeptService;
import com.atguigu.mp.service.api.EmpRoleInnerService;
import com.atguigu.mp.service.api.EmployeeService;
import com.atguigu.mp.service.api.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@SpringBootTest
public class MpDemo07RelationshipTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private EmpRoleInnerService empRoleInnerService;

    @Test
    public void test01() {
        // 目标：查询全部员工数据，并且要求能够显示他/她所在部门的名称
        // 1、先查询员工数据
        List<Employee> employeeList = employeeService.list();

        // 2、把员工数据中的部门数据提取出来
        List<Integer> deptIdList = employeeList.stream()
                .map(employee -> employee.getDeptId())
                .distinct()
                .collect(Collectors.toList());

        // 3、根据部门 id 查询部门数据
        List<Dept> deptList = deptService.listByIds(deptIdList);

        // 4、把部门的 List 集合转换为 Map 集合
        // Map 集合的 key：deptId
        // Map 集合的 value：Dept 对象
        // Collectors.toMap() 需要传入两个参数
        // 参数一：用来生成 key 的 Lambda 表达式。输入数据：Dept 对象，返回：部门 ID
        // 参数二：用来生成 value 的 Lambda 表达式。输入数据：Dept 对象，返回：Dept 对象本身
        Map<Integer, Dept> deptMap =
                deptList.stream()
                        .collect(Collectors.toMap(dept -> dept.getDeptId(), dept -> dept));

        // 5、给 employeeList 中的每一个 Employee 对象组装 Dept 对象
        employeeList.forEach(employee -> {

            // [1]获取当前员工对象的部门 ID
            Integer deptId = employee.getDeptId();

            // [2]根据部门 ID 查询对应的部门对象
            Dept dept = deptMap.get(deptId);

            // [3]给员工设置部门对象
            employee.setDept(dept);

            // [4]最终打印
            System.out.println(employee.getEmpName() + " 所在部门：" + employee.getDept().getDeptName());
        });
    }

    @Test
    public void test02() {
        // 目标：针对部门数据进行分页
        // 1、先针对部门数据本身执行分页
        // [1]创建 IPage 对象
        IPage<Dept> page = new Page<>(1, 2);

        // [2]执行分页查询
        deptService.page(page);
        List<Dept> deptList = page.getRecords();

        // 2、再查询部门对应的员工数据
        // [1]部门 ID 集合
        List<Integer> deptIdList =
                deptList.stream().map(dept -> dept.getDeptId()).toList();

        // [2]根据部门 ID 查询员工数据
        List<Employee> employeeList = employeeService.lambdaQuery()
                .in(Employee::getDeptId, deptIdList)
                .list();

        // 3、把员工数据按照部门 ID 进行分组，分组后得到一个 Map 集合
        // Map 的 key：部门 ID
        // Map 的 value：当前部门的员工 List 集合
        Map<Integer, List<Employee>> deptId2EmpListMap =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getDeptId));

        // 4、把员工集合数据组装到部门对象中
        deptList.forEach(dept -> {

            // [1]获取当前部门的 ID 值
            Integer deptId = dept.getDeptId();

            // [2]从分组后得到的 Map 集合中根据部门 ID 获取员工集合
            List<Employee> empList = deptId2EmpListMap.get(deptId);

            // [3]把员工集合组装到部门对象中
            dept.setEmpList(empList);
        });

        System.out.println();
    }

    @Test
    public void test03() {
        // 目标：查询员工的集合，给每一个员工对象组装角色集合
        // 1、查询全部员工数据
        List<Employee> employeeList = employeeService.list();

        // 2、从员工集合数据中提取所有员工 ID
        List<Integer> empIdList = employeeList.stream().map(employee -> employee.getEmpId()).toList();

        // 3、根据员工 ID 集合到中间表查询角色 ID 集合
        // [1]获取中间表对应的实体类对象的集合
        List<EmpRoleInner> empRoleInnerList = empRoleInnerService.lambdaQuery()
                .in(EmpRoleInner::getEmpId, empIdList)
                .select(EmpRoleInner::getRoleId, EmpRoleInner::getEmpId)
                .list();

        // [2]获取角色 ID 集合
        List<Integer> roleIdList = empRoleInnerList.stream().map(EmpRoleInner::getRoleId).toList();

        if (CollectionUtils.isEmpty(roleIdList)) {
            System.out.println("员工没有对应的集合，无需装配！");
            employeeList.forEach(System.out::println);
            return ;
        }

        // [3]根据员工 ID 对中间表对象集合分组
        Map<Integer, List<EmpRoleInner>> empId2EmpRoleInnerListMap =
                empRoleInnerList.stream()
                        .collect(Collectors.groupingBy(EmpRoleInner::getEmpId));

        // 4、根据角色 ID 集合到角色表查询角色对象集合（未分组，包含所有角色）
        List<SysRole> roleSummaryList = sysRoleService.lambdaQuery()
                .in(!CollectionUtils.isEmpty(roleIdList), SysRole::getRoleId, roleIdList)
                .list();

        // 5、遍历员工集合
        employeeList.forEach(employee -> {
            // [1]获取员工 ID
            Integer empId = employee.getEmpId();

            // [2]根据员工 ID 获取角色 ID 集合
            List<EmpRoleInner> empRoleInners = empId2EmpRoleInnerListMap.get(empId);
            if (CollectionUtils.isEmpty(empRoleInners)) {
                return ;
            }
            List<Integer> targetRoleIdList = empRoleInners.stream().map(EmpRoleInner::getRoleId).toList();

            // [3]对总的角色对象集合进行过滤，把我们要的角色对象保留下来
            List<SysRole> targetRoleList = roleSummaryList.stream()
                    .filter(sysRole -> targetRoleIdList.contains(sysRole.getRoleId()))
                    .toList();

            // [4]把目标角色集合组装到员工对象中
            employee.setSysRoleList(targetRoleList);
        });

        System.out.println();
    }
}
