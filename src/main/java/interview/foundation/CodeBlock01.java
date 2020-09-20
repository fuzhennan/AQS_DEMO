package interview.foundation;

/**
 * 普通代码块与一般语句的执行顺序
 *      普通代码块：在方法或语句中出现{}即为普通代码块
 *  执行顺序，谁先出现谁先执行，由他们的出现次序决定！
 *
 * 程序输出结果：
    普通代码块内的变量x=11
    普通代码块内的变量y=13
    主方法中的变量x=12
 *
 * @author fuzhennan
 */
public class CodeBlock01 {
    public static void main(String[] args){
        {
            int x = 11;
            System.out.println("普通代码块内的变量x="+x);
        }

        {
            int y = 13;
            System.out.println("普通代码块内的变量y="+y);
        }

        int x = 12;
        System.out.println("主方法中的变量x="+x);
    }
}
