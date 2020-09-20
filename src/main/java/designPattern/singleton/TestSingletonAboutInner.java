package designPattern.singleton;

/**
 * 懒汉式
 *  延迟加载，静态内部类方式
 * @author fuzhennan
 */
public class TestSingletonAboutInner {
    public static void main(String[] args){
        for (int i = 0; i <3 ; i++) {
            new Thread(() -> {
                System.out.println(SingletonAboutInner.getInstance());
            },String.valueOf(i)).start();
        }
    }
}

class SingletonAboutInner{
    private SingletonAboutInner(){}

    private static class Inner{
        private static final SingletonAboutInner instance = new SingletonAboutInner();
    }

    public static SingletonAboutInner getInstance(){
        return Inner.instance;
    }
}