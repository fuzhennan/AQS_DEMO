package AliTest;

import java.util.Scanner;

public class House {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    public static int house (int[] person) {
        // write code here
        int length = person.length;
        if (person == null || length == 0){
            return 0;
        }
        if (length == 1){
            return person[0];
        }

        int[] dp = new int[length];
        dp[0] = person[0];
        dp[1] = Math.max(person[0],person[1]);
        int number = 1, count = 0;
        if (person[0] > person[1]){
            number = 1;
        }
        for (int i = 2; i< length; i++){
            dp[i] = Math.max(dp[i-2]+person[i],dp[i-1]);
            count += number;
        }
//        return dp[length-1];
        return count;
    }
}
