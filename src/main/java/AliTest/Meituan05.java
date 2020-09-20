package AliTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Meituan05 {
    public static void main(String[] args){
        List<Integer> list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m < 1 || m > 100000){
            System.exit(0);
        }
        for(int i = 0; i < m; i++){
            int n = scanner.nextInt();
            if (list.contains(n)){
                list.remove(n);
                list.add(0,n);
            }else {
                list.add(0,n);
            }
        }
        for(Integer integer : list){
            System.out.println(integer);
        }
    }
}
