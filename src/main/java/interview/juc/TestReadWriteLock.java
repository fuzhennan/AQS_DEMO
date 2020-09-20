package interview.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author fuzhennan
 */
public class TestReadWriteLock {
    public static void main(String[] args){
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(() -> rw.set((int) (Math.random()*101)),"write").start();

        for (int i = 0; i < 100 ; i++) {
            new Thread(() -> rw.get(),"read").start();
        }
    }

}

class ReadWriteLockDemo{
    private int number;
    ReadWriteLock rw = new ReentrantReadWriteLock();

    /**
     * 读
     */
    public void get(){
        try {
            rw.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"："+number);
        }finally {
            rw.readLock().unlock();
        }
    }

    /**
     * 写
     */
    public void set(int number){
        try {
            rw.writeLock().lock();
            this.number = number;
        }finally {
            rw.writeLock().unlock();
        }
    }
}