package com.atguigu.mp.test;

import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.entity.EmpRoleInner;
import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.entity.SysRole;
import com.atguigu.mp.mapper.DeptMapper;
import com.atguigu.mp.mapper.EmployeeMapper;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class MpDemo08RelationshipTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmpRoleInnerService empRoleInnerService;

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void test01() {
        List<String> nameList = employeeMapper.selectAllEmpName();
        nameList.forEach(System.out::println);
    }

    @Test
    public void test02() {
        // 需求：查询单个 Employee 对象，要求同时关联它对应的部门
        Integer empId = 13;

        Employee employee = employeeMapper.selectEmpByIdWithDept(empId);

        System.out.println(employee.getEmpName() + " 所在部门：" + employee.getDept().getDeptName());
    }

    @Test
    public void test03() {
        // 需求：查询单个 Dept 对象，要求同时关联它对应的员工对象集合
        Integer deptId = 2;

        Dept dept = deptMapper.selectDeptByIdWithEmpList(deptId);

        System.out.println("部门id：" + dept.getDeptId() + " 部门名称：" + dept.getDeptName());

        dept.getEmpList().forEach(employee ->
                System.out.println(employee.getEmpId() + " 名字：" + employee.getEmpName()));
    }

    @Test
    public void test04() {
        // 需求：查询员工列表，并填充部门的名称（不写 SQL 语句）
        // 1、查询所有员工的列表
        List<Employee> employeeList = employeeService.list();

        // 2、从员工列表中提炼出部门 id 集合
        List<Integer> deptIdList = employeeList.stream()
                .map(Employee::getDeptId)
                .distinct()
                .toList();

        // 3、查询前面员工对应的部门数据
        List<Dept> deptList = deptService.lambdaQuery()
                .in(Dept::getDeptId, deptIdList)
                .list();

        // 4、把部门的 List 集合转换为 Map 集合
        //      key：deptId
        //      value：Dept 对象
        // collect(Collectors.toMap(用 Lambda 表达式指定谁来做键, 用 Lambda 表达式指定谁来做值))
        Map<Integer, Dept> deptMap = deptList.stream()
                .collect(Collectors.toMap(Dept::getDeptId, dept -> dept));

        // 5、把部门名称数据填充到每一个员工对象中
        employeeList.forEach(employee -> {

            // [1]通过员工对象获取部门 id 值，作为获取部门名称的依据
            Integer deptId = employee.getDeptId();

            // 下面这行代码会导致 N+1 问题————非常不建议这么写！对性能会造成大量的浪费
            // 判断依据：尽量不要在循环中执行 SQL 语句！！！
            // Dept dept = deptService.getById(deptId);

            // [2]根据部门 id 获取部门对象，进而再来获取部门名称
            // deptId ----> dept 对象
            // 此时根据部门 id 获取部门对象，就方便的方式就是从 Map 中根据键取值
            // 所以我们需要一个 Map
            //      key：deptId
            //      value：Dept 对象
            String deptName = deptMap.get(deptId).getDeptName();

            // [3]得到部门名称再给员工对象设置进去
            employee.setDeptName(deptName);

            // 6、打印数据，查看组装结果
            System.out.println("员工姓名：" + employee.getEmpName() + " 员工所在部门：" + employee.getDeptName());
        });

    }

    @Test
    public void test05() {
        // 针对部门的数据进行分页查询
        IPage<Dept> deptPage = deptService.page(new Page<Dept>(3, 2));

        List<Dept> deptList = deptPage.getRecords();

        // 为了填充员工数据，我们需要执行以下操作：
        // 1、抽取当前页部门的 id 列表，这样可以避免查询全部员工（多余不需要的员工数据会浪费内存）
        List<Integer> deptIdList = deptList.stream().map(Dept::getDeptId).toList();

        // 2、根据部门 id 列表查询对应的员工数据
        List<Employee> employeeListSummary = employeeService.lambdaQuery().in(Employee::getDeptId, deptIdList).list();

        // 3、对总的员工列表进行分组，得到一个 Map
        // Map 的 key：deptId
        // Map 的 value：专属于 deptId 的 empList
        // Collectors.groupingBy(Employee::getDeptId) 指定分组依据
        Map<Integer, List<Employee>> deptId2EmpListMap = employeeListSummary.stream().collect(Collectors.groupingBy(Employee::getDeptId));

        // 4、给每一个部门对象装配员工集合
        deptList.forEach(dept -> {

            // 把员工列表设置到当前部门的对象中
            // 注意：此时不能用总的员工列表设置给部门对象
            // 原因：总的员工列表属于当前页所有部门，不是专属当前部门的！！！
            // 改进：此时需要找到当前部门所对应的员工列表
            // dept.setEmpList(employeeListSummary);

            // [1]获取部门 id 作为获取对应员工列表的依据
            Integer deptId = dept.getDeptId();

            // [2]根据 deptId 获取对应 empList
            List<Employee> empList = deptId2EmpListMap.get(deptId);

            // [3]把员工设置给部门
            dept.setEmpList(empList);

            System.out.println("部门ID = " + dept.getDeptId() +
                    " 部门名称 = " + dept.getDeptName() +
                    " 员工姓名列表：" + (CollectionUtils.isEmpty(empList) ? "当前部门无员工" : empList.stream().map(Employee::getEmpName).toList()));
        });
    }

    @Test
    public void test06() {
        // 需求：查询员工列表数据，同时包含员工对应的角色列表
        // 1、根据部门 id 查询员工列表
        Integer deptId = 2;
        List<Employee> employeeAllList = employeeService.lambdaQuery()
                .eq(Employee::getDeptId, deptId)
                .list();

        // 2、从员工列表中抽取出员工 id，作为查询中间表的依据
        List<Integer> empIdAllList = employeeAllList.stream()
                .map(Employee::getEmpId)
                .toList();

        // 3、根据员工 id 查询中间表
        List<EmpRoleInner> empRoleInnerList = empRoleInnerService.lambdaQuery()
                .in(EmpRoleInner::getEmpId, empIdAllList)
                .list();

        // 4、从中间表数据中把角色 id 抽取出来，作为将来查询角色表的依据
        List<Integer> roleIdAllList = empRoleInnerList.stream()
                .map(EmpRoleInner::getRoleId)
                .toList();

        // 5、根据角色 id 列表查询对应的角色对象
        List<SysRole> roleAllList = sysRoleService.lambdaQuery()
                .in(SysRole::getRoleId, roleIdAllList)
                .list();

        // 6、针对中间表的查询结果（List 集合），根据 empId 进行分组
        // 键：empId
        // 值：List<EmpRoleInner>
        Map<Integer, List<EmpRoleInner>> empId2RoleIdListMap = empRoleInnerList.stream()
                .collect(Collectors.groupingBy(EmpRoleInner::getEmpId));

        // 7、给每一个员工对象设置角色集合
        employeeAllList.forEach(employee -> {

            Integer empId = employee.getEmpId();

            // 根据 empId 查找对应的角色列表
            // empId ----> sysRoleList
            // [1]根据 empId 从 Map 中获取 List<EmpRoleInner>
            // 考虑到有些员工没有对应的角色，所以创建空的集合返回
            List<EmpRoleInner> empIdInnerList = empId2RoleIdListMap.getOrDefault(empId, Collections.emptyList());

            // [2]根据 empIdInnerList 抽取角色 id
            List<Integer> roleIdList = empIdInnerList.stream().map(EmpRoleInner::getRoleId).toList();

            // [3]从总的角色集合中把符合 roleIdList 的角色对象列表取出来
            List<SysRole> sysRoleList = roleAllList.stream()
                    .filter(sysRole -> roleIdList.contains(sysRole.getRoleId()))
                    .toList();

            employee.setSysRoleList(sysRoleList);
        });

        System.out.println();
    }

    @Test
    public void test07() {
        Integer deptId = 2;
        // 1、查询当前查询条件下全部的员工列表
        List<Employee> employeeAllList = employeeService.lambdaQuery().eq(Employee::getDeptId, deptId).list();

        // 2、根据员工的 id 查询中间表实体类对象列表
        List<EmpRoleInner> empRoleInnerList = empRoleInnerService
                .lambdaQuery()
                .in(EmpRoleInner::getEmpId, employeeAllList.stream().map(Employee::getEmpId).toList())
                .list();

        // 3、根据角色 id 列表查询角色对象的集合，为了方便后面根据角色 id 取值，所以转换成了 Map 集合
        Map<Integer, SysRole> roleId2RoleMap = sysRoleService.lambdaQuery()
                .in(SysRole::getRoleId, empRoleInnerList.stream().map(EmpRoleInner::getRoleId).toList())
                .list()
                .stream()
                .collect(Collectors.toMap(SysRole::getRoleId, sysRole -> sysRole));

        // 4、为了方便后面根据员工 id 获取角色 id 集合，针对中间表对象列表进行了分组
        // 分组之后再对每一组内的元素对象进行映射
        // 原本组内的对象是 EmpRoleInner 对象，经过映射得到 roleIdList 集合
        Map<Integer, List<Integer>> empId2RoleIdListMap = empRoleInnerList.stream()
                .collect(Collectors.groupingBy(
                        EmpRoleInner::getEmpId,
                        Collectors.mapping(EmpRoleInner::getRoleId, Collectors.toList())));

        // 5、给每一个员工对象填充角色的列表集合
        employeeAllList.forEach(employee -> {
            // 从 empId2RoleIdListMap 中取出当前员工对应的角色 id 列表
            List<SysRole> sysRoleList = empId2RoleIdListMap.getOrDefault(employee.getEmpId(), Collections.emptyList())
                    .stream()
                    .map(roleId -> roleId2RoleMap.get(roleId))// 根据单个角色 id 从 roleId2RoleMap 中取出单个角色对象
                    .toList();

            // 给当前具体的员工对象设置角色列表集合
            employee.setSysRoleList(sysRoleList);
        });

        System.out.println();
    }
}
