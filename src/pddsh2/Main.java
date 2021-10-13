package pddsh2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n <= 1) {
                System.out.println(1);
            } else if (n <= 3) {
                System.out.println(n);
            } else {
                int[] dp = new int[n+1];
                dp[0] = 1;
                dp[1] = 1;
                dp[2] = 2;
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i-1] + dp[i - 3];
                }
                System.out.println(dp[n]);
            }
        }
    }
}
