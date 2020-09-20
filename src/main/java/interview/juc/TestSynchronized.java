package interview.juc;

/**
 * @author fuzhennan
 */
public class TestSynchronized {
    synchronized public static void testMethod(){}

    public void myMethod(){
        synchronized (this){
            System.out.println("同步代码块");
        }
    }

    synchronized public void test(){
        System.out.println("普通方法");
    }

    public static void main(String[] args){
        testMethod();
        TestSynchronized ts = new TestSynchronized();
        ts.myMethod();
    }
}
