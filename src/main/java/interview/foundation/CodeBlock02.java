package interview.foundation;

/**
 * 构造代码块：直接在类中定义且没有static修饰没有名字的{}代码块成为构造代码块
 * 构造代码块在每次创建对象时都会被调用，且构造代码块的优先级高于类构造函数
 *
 * 程序输出结果：
 第二构造块333
 第一代码块111
 构造方法222
 ============================
 第二构造块333
 第一代码块111
 构造方法222

 * @author fuzhennan
 */
public class CodeBlock02 {
    {
        System.out.println("第二构造块333");
    }

    public CodeBlock02(){
        System.out.println("构造方法222");
    }

    {
        System.out.println("第一代码块111");
    }

    public static void main(String[] args){
        new CodeBlock02();
        System.out.println("============================");
        new CodeBlock02();
    }
}
