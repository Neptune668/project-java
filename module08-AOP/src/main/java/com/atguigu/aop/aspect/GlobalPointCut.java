package com.atguigu.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class GlobalPointCut {

    // 引用方式：com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()
    // @Pointcut(value = "execution(* *..Calculator.*(..))")
    @Pointcut(value = "@annotation(com.atguigu.aop.annotation.PrintLogAnnotation)")
    public void pointCutExpressionGlobal(){}

}
