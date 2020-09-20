package src.practise.Value;

import java.util.HashMap;
import java.util.Map;

public class TestArgsWords {
    private static final int ONE=1;
    public static void main(String[] args){
        Map<String,Integer> m=new HashMap<String, Integer>();
        for (String arg : args) {
            int freq = m.get(arg) == null ? 0 :  m.get(arg);
            m.put(arg, freq == 0 ? ONE : freq + 1);
        }
        System.out.println(m.size()+"distinct words detected;");
        System.out.println(m);
    }
}
