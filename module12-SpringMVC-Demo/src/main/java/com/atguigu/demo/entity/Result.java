package com.atguigu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 我们封装 Result 这个类，让后端所有响应数据都按照这个格式返回
 * 为什么能涵盖所有响应结果的数据结构？
 * 因为响应无非是成功和失败：
 *      失败：不管增删改查什么操作，都返回 code 和 message
 *      成功：
 *          增删改成功，返回 code 和 message（OK）
 *          查询成功，返回 code 和 message（OK）还有数据
 * 友情提示：这个类不需要自己写，用的时候可以复制粘贴，理解就行
 * 泛型参数：指定当前响应结果要返回给前端的具体数据类型
 * @param <T>
 *
 * code 属性：使用编码的方式来精确定义返回结果是什么情况
 *      注意：这个 code 不是 HTTP 响应状态码，而是根据业务情况定义的『结果码』
 *      举例：登录失败的结果码是 8800；注册时指定的用户名已存在结果码是 8531；订单超时未支付被取消结果码是 9800
 *      核心关键特点：结果码是团队内部人为约定的，是和业务相关的一个编码，不是语法层面的编码
 *      区分语法错误和业务错误（逻辑错误），以登录失败为例：
 *          HTTP 响应状态码 200，语法层面处理请求成功
 *          结果码 8800，逻辑层面用户登录并没有成功
 * message 属性：当前请求处理结果的说明信息
 * data 属性：要返回给前端的查询结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public static final String RESULT_SUCCESS = "SUCCESS";
    public static final Integer CODE_SUCCESS = 10000;

    private Integer code;
    private String message = RESULT_SUCCESS;
    private T data;

    // 增删改操作（没有查询结果）成功
    public static Result success() {
        // 创建当前场景下 Result 对象返回
        return new Result<>(CODE_SUCCESS, RESULT_SUCCESS, null);
    }

    // 查询操作成功
    public static <QueryData> Result<QueryData> success(QueryData data) {
        // 创建当前场景下 Result 对象返回
        return new Result<>(CODE_SUCCESS, RESULT_SUCCESS, data);
    }

    // 任何一种操作失败
    public static Result failed(String message) {
        return new Result(55555, message, null);
    }
}
