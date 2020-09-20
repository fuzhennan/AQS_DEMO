package AliTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JD01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        String reg = "^.*\\d{4}.*$";
//        String reg = "\\d{4,}";
        String reg = "\\d{4,}";
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character character : c){
            sb.append(character);
        }
        if (s.length() <= 2000){
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()){
                int n = Integer.parseInt(matcher.group());
                if (n > 1000 && n <= 3999){
                    System.out.print(matcher.group() + " ");
                }
            }
        }
    }
}
