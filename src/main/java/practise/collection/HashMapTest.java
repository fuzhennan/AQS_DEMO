package practise.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 集合类不安全问题之 HashSet
 *
 *
 * @author fuzhennan
 */
public class HashMapTest {
    public static void main(String[] args){
//        Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>(300);

        for (int i = 0; i <= 300 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException

        /**
         * 1.故障现象
         *      java.util.ConcurrentModificationException
         * 2.导致原因
         * 3.解决方案
         *      ConcurrentHashMap
         * 4.优化建议
         */
    }
}
