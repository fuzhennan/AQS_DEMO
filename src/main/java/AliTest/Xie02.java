package AliTest;

import java.util.*;

public class Xie02 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        char[] temp = new char[str.length];
        dfs(str,0,temp);
        Collections.sort(list,Comparator.naturalOrder());
        for (String s : list){
            System.out.print(s);
            Set<Character> set = new HashSet<>();
            boolean flag = false;
            for (char ch : s.toCharArray()){
                if (set.contains(ch)) {
                    flag = true;
                    break;
                }else {
                    set.add(ch);
                }
                if (flag){
                    System.out.print("--circular dependency\n");
                }
            }
        }
    }

    public static void dfs(String[] str,int step,char[] temp){
        if (step == str.length){
            list.add(new String(temp));
            return;
        }
        for (int i = 0; i < str[step].length(); i++) {
            temp[step] = str[step].charAt(i);
            dfs(str,step+1,temp);
        }
    }
}
