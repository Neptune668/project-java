package com.atguigu.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) // 当前注解可以标记在方法上
@Retention(RetentionPolicy.RUNTIME) // 当前注解在运行时仍然有效
@Documented
public @interface PrintLogAnnotation {

    // 声明这个属性是为了将来注解标记在不同方法上，可以设置不同的值
    String info() default "happy";

}
