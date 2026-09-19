package com.atguigu.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LogAspect {

    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "PointCutExpression()")
    public void printLogBeforeCore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("signature.getName() = " + signature.getName());
        Object[] args = joinPoint.getArgs();
        List<Object> argList = Arrays.asList(args);
        System.out.println("[AOP前置通知] " + "方法开始了，参数列表：" + argList);
        System.out.println("[AOP前置通知] 方法开始了");//前置通知
    }

    @AfterReturning(returning = "returnValue", value =
            "PointCutExpression()")
    public void printLogAfterSuccess(Object returnValue) {
        System.out.println("[AOP返回通知] 方法成功返回了" + returnValue);//返回通知
    }

    @AfterThrowing(value = "PointCutExpression()", throwing = "throwable")
    public void printLogAfterException(JoinPoint joinPoint, Throwable throwable) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("[AOP切面][异常通知]" + methodName + "方法失败结束了！抛出了异常：" + throwable.getClass().getName());
        System.out.println("[AOP异常通知] 方法抛异常了");//异常通知
    }

    @After(value = "PointCutExpression()")
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");//后置通知
    }

    @Pointcut(value = "execution(public int com.atguigu.aop.api.Calculator.sub(int,int))")
    public void PointCutExpression() {
    }

}