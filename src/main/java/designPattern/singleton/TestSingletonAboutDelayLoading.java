package designPattern.singleton;

/**
 * 懒汉式
 *  延迟加载
 *      是指调用get方法时实例才被工厂创建，常见的实现办法是在get方法中进行new实例化。
 *
 *      单线程环境下适合，多线程不可用，多线程请用dcl，双重检测锁单例模式
 * @author fuzhennan
 */
public class TestSingletonAboutDelayLoading {
    public static void main(String[] args){
        SingletonAboutDelayLoading s1 = SingletonAboutDelayLoading.getInstance();
        SingletonAboutDelayLoading s2 = SingletonAboutDelayLoading.getInstance();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

class SingletonAboutDelayLoading{
    private static SingletonAboutDelayLoading instance;

    private SingletonAboutDelayLoading(){}

    public static SingletonAboutDelayLoading getInstance(){
        if (instance == null){
            instance = new SingletonAboutDelayLoading();
        }
        return instance;
    }
}