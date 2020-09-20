package interview.foundation;

/**
 * 类加载顺序
 * 父类静态变量>父类静态代码块>子类静态变量>子类静态代码块>父类非静态变量>父类非静态代码块>父类构造器>子类非静态变量>子类非静态代码块>子类构造器。
 * @author fuzhennan
 */

class Father{
    public Father(){
        System.out.println("父类构造函数11111");
    }

    {
        System.out.println("父类代码块22222");
    }

    static {
        System.out.println("父类静态代码块33333");
    }
}

class Son extends Father{
    public Son(){
        System.out.println("子类构造函数44444");
    }

    {
        System.out.println("子类代码块55555");
    }

    static {
        System.out.println("子类静态代码块66666");
    }
}

public class TestStaticSeq {
    static {
        System.out.println("主类静态代码块77777");
    }
    public static void main(String[] args){
        System.out.println("main方法88888");
        new Son();//78362154
        System.out.println("===============");
        new Son();//2154
        System.out.println("===============");
        new Father();//21
    }
}
