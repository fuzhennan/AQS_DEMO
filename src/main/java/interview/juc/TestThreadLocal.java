package interview.juc;

import java.util.Random;

/**
 * ThreadLocal
 *      ThreadLocal主要解决的就是让每个线程都绑定自己的值。
 *      数据--ThreadLocal--currentThread--ThreadLocalMap
 *      ThreadLocal本身不管理，不存储任何数值，全部交给ThreadLocalMap去存储，
 *      他充当一个数据和ThreadLocalMap中间的桥梁。
 *
 *      ThreadLocalMap的key存储的是当前ThreadLocal对象，value存储的是set进来的值
 *
 *      每个Thread中的map值只对当前线程可见，其他线程不可访问当前线程中的Map值
 *
 *      内存泄露问题：由于key是弱引用，value是强引用，如果ThreadLocal没有被外部强引用的情况下，可能会被垃圾回收了，
 *      key会被清理掉，value不会清理掉，这样就会key为null了，会产生内存泄露问题，所以每次使用完都要remove。
 * @author fuzhennan
 */
public class TestThreadLocal {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemoA ta = new ThreadLocalDemoA();
        Thread t1 = new Thread(ta);
        ThreadLocalDemoB tb = new ThreadLocalDemoB();
        Thread t2 = new Thread(tb);
        t1.start();t2.start();

        for (int i = 0; i < 10 ; i++) {
            TestThreadLocal.t1.set("main "+ (i+1));
            System.out.println("main get "+TestThreadLocal.t1.get());
            Thread.sleep(new Random().nextInt(101));
        }

        TestThreadLocal.t1.remove();
    }
}

class ThreadLocalDemoA implements Runnable{

    @Override
    public void run() {
        try{
            for (int i = 0; i < 10 ; i++) {
                TestThreadLocal.t1.set("A"+(i+1));
                System.out.println("A get "+TestThreadLocal.t1.get());
                Thread.sleep(new Random().nextInt(101));
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadLocalDemoB implements Runnable{

    @Override
    public void run() {
        try{
            for (int i = 0; i < 10 ; i++) {
                TestThreadLocal.t1.set("B"+(i+1));
                System.out.println("B get "+TestThreadLocal.t1.get());
                Thread.sleep(new Random().nextInt(101));
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}