package AliTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BLF01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s.replaceAll(",","");
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length; i++){
            if (c[i] >= 48 && c[i] <= 57){
                sb.append(c[i]);
            }
        }
        String a = sb.toString();
        int index = 0;
        int[][] edges = new int[(sb.length()/2) - 1][1];
        for (int i = 0; i < sb.length()/2; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = a.indexOf(index);
                index++;
            }
        }
        BLF01 blf01 = new BLF01();
        System.out.println(blf01.removeOneConnection(edges));

    }

    public String removeOneConnection(int[][] edges){
        int n = edges.length;
        int[] a = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (dfs(i, a, edges)){
                ans.add(i);
            }
        }
        return ans.toString();
    }

    public boolean dfs(int node, int[] a, int[][] edges){
        if (a[node] > 0){
            return a[node] == 2;
        }
        a[node] = 1;
        for (int b : edges[node]){
            if (a[node] == 2){
                continue;
            }
            if (a[b] == 1 || !dfs(b, a, edges)){
                return false;
            }
        }
        a[node] = 2;
        return true;
    }
}
