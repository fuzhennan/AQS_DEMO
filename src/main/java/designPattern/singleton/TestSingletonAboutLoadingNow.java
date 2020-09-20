package designPattern.singleton;

/**
 * 饿汉式：
 *  立即加载
 *      直接创建实例对象，无论是否需要这个对象都会创建
 * @author fuzhennan
 */
public class TestSingletonAboutLoadingNow {
    public static void main(String[] args){
        for (int i = 0; i <3 ; i++) {
            new Thread(() -> {
                System.out.println(SingletonAboutLoadingNow.INSTANCE);
            },String.valueOf(i)).start();
        }
    }
}

class SingletonAboutLoadingNow{
    public static final SingletonAboutLoadingNow INSTANCE = new SingletonAboutLoadingNow();

    private SingletonAboutLoadingNow(){}

}
