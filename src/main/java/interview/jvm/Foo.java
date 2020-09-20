package interview.jvm;

/**
 * @author fuzhennan
 */
public class Foo {
    public static void main(String[] args){
        boolean flag = true;
        if (flag){
            System.out.println("Hello,Java");
        }
        if (flag == true){
            System.out.println("Hello,jvm");
        }

    }
}
