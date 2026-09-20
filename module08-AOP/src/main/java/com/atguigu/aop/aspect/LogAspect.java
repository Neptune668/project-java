package com.atguigu.aop.aspect;

import com.atguigu.aop.annotation.PrintLogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect // 把当前类标记为一个切面类
@Component // 切面类必须放入 IoC 容器才能起作用
public class LogAspect {

    // 前置通知
    // value 属性：指定切入点表达式，以确定在哪些目标方法执行过程中插入通知方法
    @Before(value = "com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()")
    public void printLogBeforeCore(JoinPoint joinPoint) {

        // 返回目标方法签名信息封装的对象
        // 方法签名：方法所在类的全类名、方法权限修饰符、返回值类型、方法名、方法参数列表
        Signature signature = joinPoint.getSignature();

        // 通过方法签名对象获取目标方法的方法名
        String methodName = signature.getName();

        // 直接通过 JoinPoint 对象获取目标方法的实参列表
        Object[] args = joinPoint.getArgs();

        // 为了获取目标方法上注解的属性值，需要先给 Signature 对象转一下类型
        MethodSignature methodSignature = (MethodSignature) signature;

        // 再通过 methodSignature 对象获取 Method 对象（代表目标方法）
        Method method = methodSignature.getMethod();

        // 再通过 Method 对象获取目标方法上的注解
        // getAnnotation() 方法需要传入我们想获取的注解对象的类型
        PrintLogAnnotation annotation = method.getAnnotation(PrintLogAnnotation.class);

        // 拿到注解对象后，再获取注解中的属性值
        String info = annotation.info();

        System.out.println("[AOP切面][前置通知]" + methodName + "方法开始执行了！入参：" + (args == null ? null : Arrays.toString(args)) + " info = " + info);
    }

    // 返回通知
    @AfterReturning(
            // 切入点表达式
            value = "com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()",

            // 指定接收目标方法返回值的形参名称
            returning = "returnValue")
    public void printLogAfterCoreSuccess(JoinPoint joinPoint, Object returnValue) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("[AOP切面][返回通知]" + methodName + "方法成功结束了！返回值是：" + returnValue);
    }

    // 异常通知
    @AfterThrowing(
            // 切入点表达式
            value = "com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()",

            // 指定接收目标方法抛出异常的形参的名称
            throwing = "throwable")
    public void printLogAfterCoreFailed(JoinPoint joinPoint, Throwable throwable) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("[AOP切面][异常通知]" + methodName + "方法失败结束了！抛出了异常：" + throwable.getClass().getName());
    }

    // 后置通知
    @After(value = "com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()")
    public void printLogAfterCoreFinished(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("[AOP切面][后置通知]" + methodName + "方法最终结束了！");
    }

    // 在当前类范围内统一声明切入点表达式
    // pointCutExpression()
    @Pointcut(value = "execution(public int com.atguigu.aop.api.Calculator.sub(int, int))")
    public void pointCutExpression(){}
}
