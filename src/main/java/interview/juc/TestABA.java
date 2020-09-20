package interview.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS带来的ABA问题的解决方案
 * @author fuzhennan
 */
public class TestABA {

    public static void main(String[] args){
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

        new Thread(() -> {
            //获得初始版本号
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+" ："+"第一次版本号："+stamp);

            try {
                //睡眠一秒钟，为了让t2线程也获得第一次版本号
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" ："+"第二次版本号："+stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" ："+"第三次版本号："+stampedReference.getStamp());
        },"t1").start();

        new Thread(() ->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+" ："+"第一次版本号："+stamp);

            try {
                //睡眠三秒钟，为了让t1线程完成aba操作
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = stampedReference.compareAndSet(100,2020,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t是否修改成功："+result+"\t当前最新实际版本号："+stampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t当前实际最新值："+stampedReference.getReference());
        },"t2").start();
    }
}
