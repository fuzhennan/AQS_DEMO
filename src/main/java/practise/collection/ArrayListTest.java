package practise.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全问题之 ArrayList
 *
 *
 * 底层是object数组，初始容量为10，1.5倍扩容，
 * 支持随机快速访问（实现了RandomAccess接口）,推荐使用普通for循环遍历
 * @author fuzhennan
 */
public class ArrayListTest {
    public static void main(String[] args){
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i <= 30 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException

        /**
         * 1.故障现象
         *      java.util.ConcurrentModificationException
         * 2.导致原因
         *      使用ArrayList在输出过程中toString会使用迭代器遍历List容器，
         *      遍历过程中会有其它线程对List修改，导致modCount != expectedCount引发异常
         * 3.解决方案
         *      3.1 使用Vector类，Vector类中的所有方法都是同步的
         *      3.2 使用Collections工具类中的synchronizedList方法，new一个ArrayList
         *      3.3 java.util.concurrent.CopyOnWriteArrayList（写时复制，读写分离），适合读多写少的场景
         * 4.优化建议
         */


        /**
         * ArrayList扩容机制
         * 当声明一个ArrayList的时候，会创建一个object类型的空数组，当add第一个元素进去的时候，
         * 会调用ensureCapacityInternal方法对空数组初始化容量大小为10，当ArrayList的大小超过10之后，
         * 会调用grow方法，grow方法中调用newCapacity方法扩容并拷贝扩容后的数组返回，
         * newCapacity方法中把当前数组大小加上当前数组右移一位，int newCapacity = oldCapacity + (oldCapacity >> 1);
         * 也就是1.5倍扩容，扩容完成之后会和最小需要容量比较，
         * 如果比最小需要容量小就会把最小需要容量赋值给扩容完的容量，如果比他大，
         * 那么当前ArrayList的容量就是1.5倍扩容完的大小，然后接着扩容后的容量会和MAX_ARRAY_SIZE进行比较，
         * MAX_ARRAY_SIZE默认大小是Integer.MAX_VALUE-8，如果扩容完成的容量比这个大，就得判断实际最小需要容量到底需不需要这么多，
         * 就会调用hugeCapacity方法，比较最小需要容量和MAX_ARRAY_SIZE哪个大，
         * 最小需要容量比这个还大的话直接把Integer.MAX_VALUE值给扩容给后的新的容量，
         * 如果最小需要容量没有他大的话，那么就会把Integer.MAX_VALUE-8赋值给他，
         * 然后如果扩容后的新容量没有MAX_ARRAY_SIZE大，就不会调用huge方法，扩容后的容量就是当前的新容量。
         */
    }
}
