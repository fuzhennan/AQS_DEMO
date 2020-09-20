package AliTest;

import java.util.Scanner;

public class Meituan01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            String[] targetLine = scanner.nextLine().split(" ");
            int[] targets = new int[targetLine.length];
            for (int i = 0; i < targetLine.length; i++) {
                targets[i] = Integer.parseInt(targetLine[i]);
            }
            if (targets[0] < targets[1] || targets[0] < targets[2] || targets[0] >100000){
                System.out.println(0);
            }
            String[] targetA = scanner.nextLine().split(" ");
            int[] targetAS = new int[targetA.length];
            for (int i = 0; i < targetA.length; i++) {
                targetAS[i] = Integer.parseInt(targetA[i]);
            }

            String[] targetB = scanner.nextLine().split(" ");
            int[] targetBS = new int[targetB.length];
            for (int i = 0; i < targetB.length; i++) {
                targetBS[i] = Integer.parseInt(targetB[i]);
            }

            int count = 0;
            for (int i = 0; i < targetAS.length; i++) {
                for (int j = 0; j < targetBS.length; j++) {
                    if (targetAS[i] < 1 || targetAS[i] > targets[0] || targetBS[j] < 1 || targetBS[j] > targets[0]){
                        System.out.println(0);
                    }else if (targetAS[i] == targetBS[j]){
                        count++;
                    }
                }
            }
            System.out.println((targets[1] - count) + " " + (targets[2] - count) + " " + count);
        }
    }
}
