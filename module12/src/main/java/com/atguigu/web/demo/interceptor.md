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
