package practise.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 线程不安全，底层是双向链表（1.6之前是循环双向链表，1.7取消了循环）
 * 建议使用iterator遍历，大size千万不要用for循环，因为for循环每次都是从头开始查询，极大的影响性能
 * @author fuzhennan
 */
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        list2.add("g");

        ListIterator<String> aIter = list1.listIterator();
        Iterator<String> bIter = list2.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        //[a, d, b, e, c, f, g]
        System.out.println(list1);

        bIter = list2.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        //[d, f]
        System.out.println(list2);

        list1.removeAll(list2);
        //[a, b, e, c, g]
        System.out.println(list1);
    }
}
