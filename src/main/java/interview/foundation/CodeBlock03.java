package interview.foundation;

/**
 * 代码块执行顺序：
 *      静态代码块（只初始化一次） > 普通代码块 > 构造函数
 * @author fuzhennan
 */

class Code{
    public Code(){
        System.out.println("Code类的构造函数1111");
    }

    {
        System.out.println("Code类的构造块2222");
    }

    static {
        System.out.println("Code类的静态代码块3333");
    }
}

public class CodeBlock03 {
    {
        System.out.println("CodeBlock03的构造块4444");
    }

    static {
        System.out.println("CodeBlock03的静态代码块5555");
    }

    public CodeBlock03(){
        System.out.println("CodeBlock03的构造函数6666");
    }

    public static void main(String[] args){
        System.out.println("=========================CodeBlock03的main方法7777");
        new Code();//57321
        System.out.println("--------------");
        new Code();//57321--21
        System.out.println("--------------");
        new CodeBlock03();//57321--21--46
    }
}
