package practise.Thread;

/**
 * 死锁案例
 *
 * 产生死锁的原因：
 *      A线程拥有资源1，B线程拥有资源2，他们的资源都加了锁，又同时想拥有对方的资源而不肯退让，死锁便产生了
 *
 * 产生死锁的四个必要条件
 *      1.互斥条件：该资源任意时刻都同时只能由一个线程占用
 *      2.请求和保持条件：一个资源因请求资源而阻塞时，对自己已获得的资源保持，不释放
 *      3.不可剥夺条件：线程获得资源时在未使用完不可被其他线程剥夺，只有自己使用完才释放资源
 *      4.循环等待条件：若干进程形成一个头尾相连的循环等待资源的关系
 *
 *  如何避免线程死锁？
 *      破环产生死锁的四个必要条件中的任何一个即可。
 *      1.破坏互斥条件：该条件无法破坏，我们用锁的目的本来就是为了实现互斥（临界资源需要互斥访问）
 *      2.破坏请求和保持条件：一次性申请完所有资源
 *      3.破坏不可剥夺条件：占用部分资源的线程在申请其它资源时，如果申请不到，可以先主动释放自己的资源
 *      4.破坏循环等待条件：靠按序来申请资源。按某一顺序申请资源，释放资源的时候反序。
 * @author fuzhennan
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args){
        new Thread(() -> {
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"get resource1");

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"get resource2");

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting get resource1");

                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get resource1");
                }
            }
        },"线程2").start();
    }
}
