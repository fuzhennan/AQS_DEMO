package interview.juc;

/**
 * @author fuzhennan
 */
public class TestThreadLocal2 {
    public static ThreadLocal t = new ThreadLocal();

    public static void main(String[] args){
        TestThreadLocal2.t.set(1);
        TestThreadLocal2.t.set(2);
        TestThreadLocal2.t.set(3);
        System.out.println(TestThreadLocal2.t.get());
    }
}
