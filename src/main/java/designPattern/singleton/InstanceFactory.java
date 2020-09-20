package designPattern.singleton;

/**
 * 懒汉式
 *  延迟加载，静态内部类方式
 * @author fuzhennan
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static InstanceHolder instance = new InstanceHolder();
    }

    public static InstanceHolder getInstance(){
        return InstanceHolder.instance;
    }
}

class TestInstanceFactory {
    public static void main(String[] args){
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(InstanceFactory.getInstance());
                }
            },String.valueOf(i)).start();
        }
    }
}
