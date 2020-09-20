package designPattern.singleton;

/**
 * 双重检验锁实现单例模式
 *
 *  DCL机制不一定线程安全，原因是有指令重排序的存在，加入volatile可以禁止instance = new DCLSingleton()指令重排序
 *                                                    同时也使得在多线程环境下的instance达到可见性
 *  原因在于第一个线程执行到第一次检测，读取到的instance不为null时，instance的引用对象可能没有初始化完成
 *
 *  instance = new DCLSingleton(); 可以分为三步完成
 *      1.分配对象内存空间 2.初始化对象 3.设置instance指向刚刚分配好的内存地址
 *
 *  当一条线程访问instance不为null时，由于instance实例未必已经初始化完成，所以会造成线程安全问题
 * @author fuzhennan
 */
public class TestDCLSingleton {
    public static void main(String[] args){
        for (int i = 0; i <= 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(DCLSingleton.getInstance());
                }
            },String.valueOf(i)).start();
        }
    }
}

class DCLSingleton{
    /**需要加volatile禁止指令重排序*/
    private volatile static DCLSingleton instance;

    private DCLSingleton(){
        System.out.println(Thread.currentThread().getName()+":"+"我是构造函数");
    }

    public static DCLSingleton getInstance(){
        /**先判断对象是否被实例过，没有实例化在进行加锁*/
        if (instance == null){
            //类对象加锁，假设线程1拿到锁，往下执行，实例化对象，释放锁，
            // 线程2拿到锁，如果不判断instance是否已经被实例化过，就会多次实例化，违背了单例的原则
            synchronized (DCLSingleton.class){
                //第二次检测对象是否已经被之前的线程实例过
                if (instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}