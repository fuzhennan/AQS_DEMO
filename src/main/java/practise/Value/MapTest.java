package src.practise.Value;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args){
        Map<String,Integer> m1=new HashMap<String, Integer>();
        Map m2=new TreeMap();
        Map m4=new LinkedHashMap();

        m1.put("one", 1);
        m1.put("two",2);
        m1.put("three",3);
        m1.put("four",4);
        m2.put("A",1);
        m2.put("B",2);
        m4.put("one",1);
        m4.put("two",2);
        m4.put("three",3);

        System.out.println(m1);
        System.out.println(m4);
        System.out.println(m1.size());
        System.out.println(m1.containsKey("one"));
        System.out.println(m1.containsValue(1));

        if (m1.containsKey("two")){
            int i= m1.get("two");
            System.out.println(i);
        }

        Map m3=new HashMap(m1);
        System.out.println(m3);
        m3.putAll(m2);
        System.out.println(m3);

    }
}
