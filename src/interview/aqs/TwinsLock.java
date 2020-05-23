package interview.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * aqs demo
 * 设置一个同步工具，该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程访问将被阻塞
 *      由于至多两个线程同时访问，所以用共享式同步状态获取
 * @author fuzhennan
 */
public class TwinsLock implements Lock{
    /**设置初始状态status为2*/
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer{
        /**
         * 构造方法
         * 当构造的参数status小于2时，将抛出异常
         * @param count，初始状态status
         */
        Sync(int count){
            if (count < 2){
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        /**
         * 共享式获取同步状态
         * 当返回的newCount大于等于0时才获取同步状态
         * @param reduceCount 减少的同步状态数
         * @return newCount
         */
        @Override
        public int tryAcquireShared(int reduceCount){
            for (;;){
                int current = getState();
                int newCount = current-reduceCount;
                //当newCount小于0的时候，返回newCount，但是因为newCount大于等于0时才会获取同步状态，
                //当newCount大于0的时候，||表达式左边恒为false，这时只需要看compareAndSetState是否成功，若成功则返回，
                //      不成功继续自旋“死循环”式尝试获取同步状态
                if (newCount < 0 || compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        /**
         * 共享式释放同步状态
         * 当且仅当cas设置state成功时，才返回true，否则自选“死循环”式释放同步状态
         * @param reduceCount 减少的同步状态数
         * @return true
         */
        @Override
        protected boolean tryReleaseShared(int reduceCount) {
            for (;;){
                int current = getState();
                int newCount = current+reduceCount;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    /**
     * 加锁，每调用一次，同步状态-1
     */
    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    /**
     * 释放锁，每调用一次，同步状态+1
     */
    @Override
    public void unlock() {
        sync.releaseShared(1);
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
