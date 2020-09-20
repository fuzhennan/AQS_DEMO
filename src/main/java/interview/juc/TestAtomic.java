package interview.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性
 *  i++的原子性问题
 *      int i = 1;//1
 *      i = i++;//1
 *
 *      分为三步：读-改-写
 *      int temp = i;
 *      i = i + 1;
 *      i = temp;
 *
 *      int i = 1;  首先在栈中有一个i，在局部变量表中i的值为1，
 *     i = i++;    i++是先使用i，在++，在操作数栈中把i压栈，值为1，然后局部变量表中的i++，结果为2
 *                  然后把右边操作结束了得把值赋值给左边，也就是把操作数栈中的i（1）赋值给局部变量表中的i，覆盖了
 *                  最终结果还是1
 *
 *  并发环境下i++的解决方案
 *  1.加锁 synchronized
 *  2. jdk1.5以后再juc下面的Atomic包下提供了常用的原子变量，比如AtomicInteger
 *      实现原理：
 *      1.volatile保证内存可见性
 *      2.CAS（compare and swap）算法保证数据的原子性
 *          CAS包含了三个操作数，内存值v，期望值a，修改值b
 *          当且仅当v=a时才会进行修改，否则什么也不会做，也不释放资源，一直比较，直到相等
 *
 * @author fuzhennan
 */
public class TestAtomic{
    public static void main(String[] args){
        AtomicDemo atomic = new AtomicDemo();
        for (int i = 0; i < 10; i++){
            new Thread(atomic).start();
        }
    }
}

class AtomicDemo implements Runnable{
//    private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber(){
//        return serialNumber++;

        /**
         * getAndIncrement() = i++
         * incrementAndGet() = ++i
         *
         */
        return serialNumber.getAndIncrement();
    }
}