package com.atguigu.mp.mapper;

import com.atguigu.mp.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper 接口要点
 * 1、一定要放在 IoC 容器能够扫描到的包下
 * 2、必须继承 BaseMapper，BaseMapper 泛型传入实体类类型
 * 3、使用 @Mapper 注解标记 Mapper 接口，使其实现类对象放入 IoC 容器
 * 4、Mybatis 框架会在运行时动态生成接口的实现类，不需要我们自己写
 * 5、如果只是做常规操作，那么就不需要在接口中编写代码
 * 6、如果不想在每个 Mapper 接口上分别标记 @Mapper 注解，也可以在主启动类或配置类上 @MapperScan 注解指定 Mapper 接口所在包即可
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 原生 Mybatis 功能举例：查询所有员工姓名
     * @return
     */
    List<String> selectAllEmpName();

    Employee selectEmpByIdWithDept(Integer empId);
}
