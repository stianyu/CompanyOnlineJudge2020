package dongfangcaifu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt() / 100;
            if (n < 2) {
                System.out.println(n);
            } else {
                int first = 1;
                int second = 2;
                int res = 0;
                for (int i = 3; i <= n; i++) {
                    res = first + second;
                    first = second;
                    second = res;
                }
                System.out.println(res);
            }
        }
    }
}
