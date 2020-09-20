package AliTest;


import java.util.Scanner;

public class DiDi01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (scanner.hasNext()){
            String s = scanner.nextLine();

            int x = s.length() / n;
//        int y = s.length() % n;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n*x; i=i+n) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(s.substring(i,i+n));
                sb.append(sb2.reverse());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(s.substring(n*x,s.length()));
            sb.append(sb3.reverse());
            System.out.println(sb);
        }

    }
}
