package com.atguigu.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Demo02_CheckedExceptionTest {

    public static void main(String[] args) /*throws FileNotFoundException, IOException, Throwable*/ {
        // 编译时异常：在代码编译过程中就会检查是否存在抛异常的风险，编译会报错
        // 受检异常：需要接受检查的异常
        // 代码含义：从硬盘上读取一个名叫 a.txt 的文件，以输入流的形式读取到内存中
        // Unhandled exception: java.io.FileNotFoundException
        // 没有被处理的异常：文件找不到异常
        // 报错的用意是告诉我们当前操作在将来运行时有风险：a.txt 文件在硬盘上找不到
        // 面对此时编译报错，我们必须在写代码时（开发过程中）用代码的方式给出未来风险的解决方案
        // 解决方案一：把代表风险的当前异常继续向上声明，告诉上层调用者，当前代码的风险，不给具体的处理方案
        // 语法：在当前方法声明位置使用 throws 关键词，后面跟上编译时异常的类型，后跟异常可以多个
        // 含义：告诉上层调用者，当前代码执行过程中有抛指定异常的风险，但不表示一定会出问题
        // 解决方案二：针对有风险的代码使用 try ... catch ... finally 结构捕捉异常
        // try 单词：尝试，针对有风险的代码尝试执行
        // catch 单词：捕捉、捕获，如果 try 尝试执行的代码真的在运行时抛异常，那么 JVM 就会进入 catch 块执行备用方案，同时把捕获到的异常对象传入 catch 块
        // finally 单词：最终、最后，不管 try 块代码是否真的抛异常，finally 块代码都必然执行，通常用来做资源释放类操作
        // try ... catch ... finally 灵活组合：try 必须有；catch 和 finally 可选，但 catch 和 finally 不能都没有
        // 多个 catch 块中，后面捕获的异常必须比前面捕获的范围大，小范围异常放前面，大的放后面
        // catch 块中代码编写的建议：
        // 建议 1：最好不要让 catch 块中完全空着什么代码都不写，这等于没有提供任何备选方案
        // 建议 2：在项目全局来看，有时仅仅把异常捕获，私自处理并不是最佳方案；很多时候，我们需要让项目系统管理员知道出现的问题
        //      第一种情况：小问题，不需要系统管理员专门去处理，在 catch 块局部处理即可
        //      第二种情况：大问题，完全有必要让系统管理员知晓并参与协助处理，此时需要把捕获到的异常继续抛出
        //          具体做法：把编译时异常包装为运行时异常再使用 throw 关键字抛出
        // throw 和 throws 的区别：
        // 1、首先明确：二者完全不同，不能互相替代
        // 2、核心区别：throws 只是声明有风险不代表一定会出问题，仅提示风险预警；throw 真的要抛一个异常，动真格的
        // 3、语法层面：throw 写在方法体、catch 块、代码块等语法结构内，总之它是可以执行的语句；throws 必须写在方法或构造器声明的位置
        // 4、后面跟的：throw 后面必须是一个具体的异常对象；throws 后面必须是异常类型
        // 在异常信息中 Caused by 的含义：由...引起
        // 具体例子：java.lang.RuntimeException Caused by: java.io.FileNotFoundException
        // 中文翻译：运行时异常是由文件找不到异常所引起的
        // 开发启示：当我们看到长篇大论的异常信息后，要重点关注最后一个 Caused by，因为它是整个异常链条上的根本原因
        // 根本原因：大概率可以帮我们定位到代码的故障位置
        // 异常信息：本质上是详细告诉我们具体出了什么问题，异常对象一层一层是怎么包装的，是来帮助我们的
        try {
            // 尝试执行的风险代码
            new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            // 提前准备好的故障预案
            System.out.println("[catch块]我们捕获到了异常：" + e);
            throw new RuntimeException(e);
        }finally {
            System.out.println("[finally块]必然执行的代码");
        }

        System.out.println("[try...catch...结构后面的代码]正常执行……");
    }

}
