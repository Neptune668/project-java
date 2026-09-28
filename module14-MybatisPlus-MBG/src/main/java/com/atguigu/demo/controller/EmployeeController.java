package com.atguigu.demo.controller;

import com.atguigu.demo.entity.Emp;
import com.atguigu.demo.entity.EmpCondition;
import com.atguigu.demo.service.EmpService;
import com.atguigu.demo.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmpService empService;

    // 分页 + 多条件查询
    // POST /emp/page
    // 前端发送的查询条件数据：
    // empNo 精确查询（eq）
    // deptId 精确查询（eq）
    // empBirthday 范围查询（between）
    // empName 模糊查询（like）
    // empSalary 范围查询（between）
    // phoneNum 精确查询（eq）
    // 以上各个条件，前端都不一定发送给后端
    // 分页还需要当前页页码和页容量
    @PostMapping("/emp/page")
    public Result<IPage<Emp>> getEmpPage(@RequestBody EmpCondition condition) {

        IPage<Emp> page = empService.lambdaQuery()
                .eq(condition.getEmpNo() != null, Emp::getEmpNo, condition.getEmpNo())
                .eq(condition.getDeptId() != null, Emp::getDeptId, condition.getDeptId())
                .between(condition.getBirthdayBegin() != null || condition.getBirthdayEnd() != null,
                        Emp::getEmpBirthday,
                        condition.getBirthdayBegin(),
                        condition.getBirthdayEnd())
                .like(StringUtils.hasText(condition.getEmpName()) && StringUtils.hasLength(condition.getEmpName()),
                        Emp::getEmpName,
                        condition.getEmpName())
                .between(condition.getEmpSalaryMax() != null || condition.getEmpSalaryMin() != null,
                        Emp::getEmpSalary,
                        condition.getEmpSalaryMin(),
                        condition.getEmpSalaryMax())
                .eq(condition.getPhoneNum() != null, Emp::getPhoneNum, condition.getPhoneNum())
                .page(new Page<>(condition.getPageNum(), condition.getPageSize()));

        return Result.success(page);
    }

    // 按主键查询
    // GET /emp/{id}
    @GetMapping("/emp/{id}")
    public Result<Emp> getEmpById(@PathVariable("id") Integer id) {
        return Result.success(empService.getById(id));
    }

    // 新增员工记录
    // POST /emp
    @PostMapping("/emp")
    public Result<Void> saveEmp(@RequestBody Emp emp) {

        boolean saveResult = empService.save(emp);

        if (!saveResult) {
            throw new RuntimeException("保存失败！");
        }

        return Result.success();
    }

    // 更新员工记录
    // PUT /emp
    @PutMapping("/emp")
    public Result<Void> updateEmp(@RequestBody Emp emp) {

        if (emp.getEmpId() == null) {
            throw new RuntimeException("员工记录 id 值丢失，无法更新员工记录！");
        }

        // 目前这个写法会导致自动填充不起作用，因为这里没有使用整个实体类对象
        boolean updateResult = empService.lambdaUpdate()
                .set(emp.getDeptId() != null, Emp::getDeptId, emp.getDeptId())
                .set(emp.getEmpBirthday() != null, Emp::getEmpBirthday, emp.getEmpBirthday())
                .set(emp.getEmpName() != null, Emp::getEmpName, emp.getEmpName())
                .set(emp.getEmpNo() != null, Emp::getEmpNo, emp.getEmpNo())
                .set(emp.getEmpSalary() != null && emp.getEmpSalary() > 0, Emp::getEmpSalary, emp.getEmpSalary())
                .set(emp.getPhoneNum() != null, Emp::getPhoneNum, emp.getPhoneNum())
                .set(Emp::getUpdateTime, LocalDateTime.now())
                .eq(Emp::getEmpId, emp.getEmpId())
                .update();

        if (!updateResult) {
            throw new RuntimeException("更新失败！");
        }

        return Result.success();
    }

    // 删除员工记录（逻辑删除）
    // DELETE /emp/{id}
    @DeleteMapping("/emp/{id}")
    public Result<Void> removeEmpById(@PathVariable("id") Integer id) {

        boolean removeResult = empService.removeById(id);

        if (!removeResult) {
            throw new RuntimeException("删除失败！");
        }

        return Result.success();
    }

    // 按部门统计人数
    // GET /emp/count/group/by/dept
    @GetMapping("/emp/count/group/by/dept")
    public Result<Map<Integer, Long>> getEmpCountByDeptGroup() {

        // 1、创建 QueryWrapper 对象
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.select("dept_id", "count(*) as empCount").groupBy("dept_id");

        // 2、执行查询
        List<Map<String, Object>> mapList = empService.listMaps(wrapper);

        // 3、把 mapList 转换为最终需要的结构
        Map<Integer, Long> finalMap = mapList.stream().collect(
                Collectors.toMap(
                        map -> (Integer) map.get("dept_id"),
                        map -> (Long) map.get("empCount")));

        return Result.success(finalMap);
    }
}
