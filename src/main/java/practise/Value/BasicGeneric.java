package src.practise.Value;

import java.util.*;

public class BasicGeneric {
    public static void main(String[] args){
        List<String>c=new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        for (String s : c) {
            System.out.println(s);
        }

        Collection<String> c2=new HashSet<String>();
        c2.add("aaa");
        c2.add("bbb");
        c2.add("ccc");
        for (Iterator<String> it=c2.iterator();it.hasNext();){
            String s=it.next();
            System.out.println(s);
        }
    }
}

class MyName implements Comparable<MyName>{
    int age;

    @Override
    public int compareTo(MyName o) {
        return Integer.compare(this.age, o.age);
    }
}
