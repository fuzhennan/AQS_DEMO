package interview.juc;

/**
 * @author fuzhennan
 */
public class TestVolatileReOrder {
    int a = 0;
    boolean flag = false;

    public void write(){
        a = 1;
        flag = true;
    }

    public void read(){
        if (flag){
            a=a+5;
            System.out.println(a);
        }
    }
}
