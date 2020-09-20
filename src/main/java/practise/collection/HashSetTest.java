package practise.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全问题之 HashSet
 *
 * HashSet底层数据结构就是HashMap
 *          public HashSet() {
 *              map = new HashMap<>();
 *          }
 *
 * @author fuzhennan
 */

public class HashSetTest {
    public static void main(String[] args){
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i <= 300 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException

        /**
         * 1.故障现象
         *      java.util.ConcurrentModificationException
         * 2.导致原因
         *      使用HashSet在输出过程中toString会使用迭代器遍历List容器，
         *      遍历过程中会有其它线程对List修改，导致modCount != expectedCount引发异常
         * 3.解决方案
         *      3.1 使用java.util.concurrent.CopyOnWriteArraySet，本质上也是使用的CopyOnWriteArrayList
         *              public CopyOnWriteArraySet() {
         *                  al = new CopyOnWriteArrayList<E>();
         *               }
         *      3.2 使用Collections.synchronizedSet
         * 4.优化建议
         */

        /**
         * HashSet的add方法本质上调用的是HashMap的put方法，key值即为add的元素，value即为object常量
         *      private static final Object PRESENT = new Object();
         *     public boolean add(E e) {
                    return map.put(e, PRESENT)==null;
                 }
         */

        /**
         * HashSet如何检查重复
         * 
         */
    }
}
