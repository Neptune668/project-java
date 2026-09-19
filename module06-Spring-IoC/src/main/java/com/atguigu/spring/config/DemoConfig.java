package com.atguigu.spring.config;

import com.atguigu.spring.demo.CarFactory;
import com.atguigu.spring.demo.CarMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 也必须在扫描包的范围内才能生效
@Configuration

// classpath 表示到类路径下查找指定的资源
// classpath 后面写英文冒号，冒号后面写属性文件的路径
// 注意：是路径而不是仅仅写文件名，如果属性文件在某个目录下那就需要把所在目录也写上
@PropertySource(value = "classpath:config/atguigu.properties") // 指定外部属性文件的位置
public class DemoConfig {

    // 做法说明：
    // 1、声明一个方法，把我们想放入 IoC 容器的对象作为方法返回值
    // 2、在方法体内我们自己创建它的对象
    // 3、在方法上使用 @Bean 注解标记这个方法
    @Bean
    public CarMachine carMachine() {
        return new CarMachine("比亚迪·秦", 100000.00);
    }

    @Bean
    public CarFactory carFactory() {
        // 这里关于 CarFactory 所需要的 CarMachine 对象：
        // 如果我们自己创建 CarMachine 对象，那么这里就不是从 IoC 容器中拿到再装配进来
        // return new CarFactory("比亚迪工厂", 333.33, new CarMachine());
        // 通常来说，我们都需要使用 IoC 容器中的组件对象来实现 bean 之间的装配
        // 具体做法：调用前面标记了 @Bean 注解的方法从而拿到 IoC 容器中的那个对象
        return new CarFactory("比亚迪工厂", 333.33, carMachine());

        // 疑问：上面那个标记了 @Bean 注解的方法不是一样 new 了对象么？有什么区别？
        // 答：区别在于调用 @Bean 注解方法时，Spring 底层会首先检查 IoC 容器中是否存在对应的对象
        // 如果不存在，就真的执行这个方法，创建对象、放入 IoC 容器
        // 如果存在，就不会真的调用这个方法了，也就保证 IoC 容器中就是先前创建的那个对象，不会重复创建
    }

}
