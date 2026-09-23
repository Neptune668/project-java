```java
//Demo01Interceptor
package com.atguigu.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Order(4)
public class Demo01Interceptor implements HandlerInterceptor {

    // 执行的时机：目标 Controller 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[拦截器][Demo01Interceptor][preHandle()]");

        // 返回值决定当前请求是否放行
        // 返回 true：放行，让请求继续访问它原本要访问的资源
        // 返回 false：不放行，当前请求原本要执行的后续操作都不执行了，导致当前请求没有响应，所以需要在拦截器中当前方法内给出响应
        return true;
    }

    // 执行的时机：目标 Controller 方法执行之后、再等底层也把 Controller 方法的返回值解析为响应体数据之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[拦截器][Demo01Interceptor][postHandle()]");
    }

    // 执行的时机：当一个请求完全处理完成，已准备好响应的数据时执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[拦截器][Demo01Interceptor][afterCompletion()]");
    }
}

```
```java
//Demo02Interceptor
package com.atguigu.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Order(3)
public class Demo02Interceptor implements HandlerInterceptor {

    // 执行的时机：目标 Controller 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[拦截器][Demo02Interceptor][preHandle()]");

        // 返回值决定当前请求是否放行
        // 返回 true：放行，让请求继续访问它原本要访问的资源
        // 返回 false：不放行，当前请求原本要执行的后续操作都不执行了，导致当前请求没有响应，所以需要在拦截器中当前方法内给出响应
        return true;
    }

    // 执行的时机：目标 Controller 方法执行之后、再等底层也把 Controller 方法的返回值解析为响应体数据之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[拦截器][Demo02Interceptor][postHandle()]");
    }

    // 执行的时机：当一个请求完全处理完成，已准备好响应的数据时执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[拦截器][Demo02Interceptor][afterCompletion()]");
    }

}

```
```java
//Demo03Interceptor
package com.atguigu.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Order(2)
public class Demo03Interceptor implements HandlerInterceptor {

    // 执行的时机：目标 Controller 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[拦截器][Demo03Interceptor][preHandle()]");

        // 返回值决定当前请求是否放行
        // 返回 true：放行，让请求继续访问它原本要访问的资源
        // 返回 false：不放行，当前请求原本要执行的后续操作都不执行了，导致当前请求没有响应，所以需要在拦截器中当前方法内给出响应
        return true;
    }

    // 执行的时机：目标 Controller 方法执行之后、再等底层也把 Controller 方法的返回值解析为响应体数据之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[拦截器][Demo03Interceptor][postHandle()]");
    }

    // 执行的时机：当一个请求完全处理完成，已准备好响应的数据时执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[拦截器][Demo03Interceptor][afterCompletion()]");
    }

}

```
```java
//Demo04Interceptor
package com.atguigu.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Order(1)
public class Demo04Interceptor implements HandlerInterceptor {

    // 执行的时机：目标 Controller 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[拦截器][Demo04Interceptor][preHandle()]");

        // 返回值决定当前请求是否放行
        // 返回 true：放行，让请求继续访问它原本要访问的资源
        // 返回 false：不放行，当前请求原本要执行的后续操作都不执行了，导致当前请求没有响应，所以需要在拦截器中当前方法内给出响应
        return true;
    }

    // 执行的时机：目标 Controller 方法执行之后、再等底层也把 Controller 方法的返回值解析为响应体数据之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[拦截器][Demo04Interceptor][postHandle()]");
    }

    // 执行的时机：当一个请求完全处理完成，已准备好响应的数据时执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[拦截器][Demo04Interceptor][afterCompletion()]");
    }

}

```
```java
//DemoMonsterInterceptor
package com.atguigu.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

@Component
public class DemoMonsterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1、获取请求参数：调用原生 request 对象的方法
        String monster = request.getParameter("monster");

        // 2、检查 monster 是否等于 Peter
        // 字符串类型变量和字符串字面量比较时，最佳写法：用字面量字符串调用 equals() 方法
        // 因为如果是用字符串变量调用方法还需要先判断它是否为 null
        // if (monster == null || !monster.equals("Peter"))
        if ("Peter".equals(monster)) {
            // 3、满足既定条件则放行
            return true;
        }

        // 4、不满足条件就不放行
        // 不放行的情况，需要返回一个错误信息，此时需要使用原生的响应对象
        // [1]设置响应体的字符集
        response.setCharacterEncoding("UTF-8");
        // [2]获取 Writer 对象，专门负责把响应数据写入缓冲区
        PrintWriter writer = response.getWriter();
        // [3]把响应数据通过 writer 对象写入缓冲区
        writer.write("抱歉！您的请求不符合要求，没有携带指定的怪兽！");
        // [4]冲刷缓冲区，让服务器把缓冲区的数据作为响应返回给前端
        writer.flush();

        return false;
    }
}

```
```java 
//DemoWebConfig
package com.atguigu.demo.config;

import com.atguigu.demo.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoWebConfig implements WebMvcConfigurer {

//    @Autowired
//    private Demo01Interceptor demo01Interceptor;
//
//    @Autowired
//    private Demo02Interceptor demo02Interceptor;
//
//    @Autowired
//    private Demo03Interceptor demo03Interceptor;
//
//    @Autowired
//    private Demo04Interceptor demo04Interceptor;
//
//    @Autowired
//    private DemoMonsterInterceptor demoMonsterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 提问：可以自己 new 拦截器的对象吗？
        // 回答：绝对不行！！！
        // 理由 1：自己 new 的对象并不是 IoC 容器中管理的那个对象，自己 new 的对象不能享受到 IoC 容器对对象的增强
        // 理由 2：在全局范围内使用的大组件创建对象的代码在项目中散落各处，非常不利于统一管理和维护
        // 结论：必须要从 IoC 容器中获取出来这个对象进行操作
        // registry.addInterceptor(new Demo01Interceptor());

        registry.addInterceptor(demo04Interceptor)
                .addPathPatterns("/fruit/**") // 匹配多层目录，包括零层、单层、多层
                .excludePathPatterns("/fruit/apple/red/**") // 配置不拦截的路径，用不用通配符都行，看需求
                .order(4);

        registry.addInterceptor(demo03Interceptor)
                .addPathPatterns("/fruit/*") // 匹配单层目录，不匹配零层和多层
                .order(3);

        // 注册另一个拦截器
        registry.addInterceptor(demo02Interceptor)
                .addPathPatterns("/tiger/list") // 精确匹配
                .order(2);

        // 调用注册器对象的方法添加拦截器对象
        // registry.addInterceptor(拦截器对象);
        // 默认情况可以不指定拦截请求的范围，默认拦截所有的请求（所有归 SpringMVC 管的请求）
        registry.addInterceptor(demo01Interceptor).order(1);

        // 注册练习中的拦截器
        registry.addInterceptor(demoMonsterInterceptor);
    }
}

```
```java
//TigerExceptionHandler
package com.atguigu.demo.config;

import com.atguigu.demo.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TigerExceptionHandler {

    // 如果一个异常对象和多个异常处理方法都匹配，那么范围最精确、最接近的优先
    // 把异常类型和处理异常的方法进行了映射
    @ExceptionHandler(value = {ArithmeticException.class})
    public Result<Void> arithmeticExceptionHandler(ArithmeticException exception) {

        // 把异常信息封装到失败状态的 Result 对象中，Result 对象作为响应体返回给前端
        return Result.failed("[全局范围][异常映射][小范围]" + exception.getMessage());
    }

    // NullPointerException 是 Exception 的子类，所以能够匹配，可以映射
    @ExceptionHandler(value = Exception.class)
    public Result<Void> allExceptionHandler(Exception exception) {

        // 把异常信息封装到失败状态的 Result 对象中，Result 对象作为响应体返回给前端
        return Result.failed("[全局范围][异常映射][大范围]" + exception.getMessage());
    }
}

```
