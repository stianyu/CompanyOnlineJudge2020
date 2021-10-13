package didi;

import java.util.Scanner;

public class Main4 {
    static long[] fobi;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            fobi = generate(n*n);
            long[][] res = new long[n][n];
            helper(n, n, res);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    private static long[] generate(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp;
    }

    public static void helper(int m, int n, long[][] nums) {
        int l = 0, r = n - 1, t = 0, d = m - 1;
        int count = m * n;
        while (true) {
            for (int i = l; t <= d && i <= r ; i++) {
                count--;
                nums[t][i] = fobi[count];
            }
            t++;
            for (int i = t; l <= r && i <= d; i++) {
                count--;
                nums[i][r] = fobi[count];
            }
            r--;
            for (int i = r; t <= d && i >= l ; i--) {
                count--;
                nums[d][i] = fobi[count];
            }
            d--;
            for (int i = d; l <= r && i >= t; i--) {
                count--;
                nums[i][l] = fobi[count];

            }
            l++;
            if (count == 0) {
                break;
            }
        }
    }
}
