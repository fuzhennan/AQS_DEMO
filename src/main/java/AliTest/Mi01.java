package AliTest;

import java.util.Scanner;

/**
 * 123 12345678 123abcABC!!!
 * 0符合要求 1长度不符合 2类型不符合
 * 1 2 0
 */
public class Mi01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] targetLine = scanner.nextLine().split(" ");
        for (int i = 0; i < targetLine.length ; i++) {
            String s = targetLine[i];
            if (s.length() < 8 || s.length() > 120){
                System.out.println(1);
            }
            int num = 0,zm = 0,zm1 = 0,fh = 0;
            for(int j = 0; j < s.length(); j++){
                if (s.charAt(j) >= 48 && s.charAt(j) <= 57 ){
                    num ++;
                }else if (s.charAt(j) >= 65 && s.charAt(j) <= 90){
                    zm ++;
                }else if (s.charAt(j) >= 97 && s.charAt(j) <= 122){
                    zm1 ++;
                }else {
                    fh ++;
                }
            }
            if (zm > 0 && num > 0 && zm1 > 0 && fh > 0){
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }
}
