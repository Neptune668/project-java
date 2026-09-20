package com.atguigu.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 模拟缓存切面的功能效果
 * 执行查询之前：检查缓存中是否存在所需要的数据
 * 目标方法：查询数据库，获取所需要的数据
 * 查询成功之后：把查询到的数据存入缓存
 * 查询失败之后：返回空值或打印异常信息
 * 最终收尾操作：打印操作结束
 */
@Component
@Aspect
@Order(15)
public class CacheAspect {

    // 提问：环绕通知方法为什么一定要有返回值？
    // 回答：外部调用者通过环绕通知的代理方法调用目标方法获取目标方法的返回值，除此之外没有别的途径拿到这个返回值
    @Around(value = "com.atguigu.aop.aspect.GlobalPointCut.pointCutExpressionGlobal()")
    public Object getDataFromCache(ProceedingJoinPoint joinPoint) {

        // 通过 ProceedingJoinPoint 对象获取外部调用目标方法时传入的实参数组
        Object[] args = joinPoint.getArgs();

        // 声明一个 Object 类型的变量，模拟缓存数据
        Object cacheData = null;

        // 获取目标方法的名称
        String methodName = joinPoint.getSignature().getName();

        try {
            System.out.println("[缓存切面][环绕通知]" + methodName + "开始执行，入参：" + (args == null ? null : Arrays.toString(args)));
            // 核心操作：调用目标方法
            if (cacheData == null) {
                // 真实调用目标方法
                Object targetMethodReturnValue = joinPoint.proceed(args);
                System.out.println("[缓存切面][环绕通知]成功结束，返回值：" + targetMethodReturnValue);

                // 把目标方法的返回值存入缓存
                cacheData = targetMethodReturnValue;
            }

            // 执行到这里，cacheData 要么有值，要么已调用目标方法，所以直接返回
            return cacheData;

        } catch (Throwable throwable) {

            System.out.println("[缓存切面][环绕通知]" + methodName + "抛出异常，异常类型：" + throwable.getClass().getName());

            // 目标方法执行过程中抛出异常，所以我们在这里就封装异常对象继续抛出
            // 由项目全局范围的异常处理机制统一处理
            // 语法层面的具体做法：把捕获到的异常对象封装为运行时异常继续向上抛出
            throw new RuntimeException(throwable);

        } finally {
            System.out.println("[缓存切面][环绕通知]" + methodName + "最终结束");
        }

        // Unreachable statement 含义：不可到达的代码
        // 当前方法的结局是完全确定的：
        //      要么执行 try 块中的 return
        //      要么执行 catch 块中的 throw
        // 所以最外面任何其它的代码就都执行不到了
        // return null;
    }

}
