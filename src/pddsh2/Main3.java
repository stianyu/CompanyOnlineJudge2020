package pddsh2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] nums = new int[n * m];
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                System.arraycopy(num,0,nums, i*n, n);
            }
            int[] dp = new int[n*m];
            dp[0] = nums[0];
            int sum = 0;
            for (int i = 1; i < n*m; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
                sum = Math.max(sum, dp[i]);
            }
            System.out.println(sum);
        }
    }
}

/*
5 3
1 3 -9 2 4

5 1
1 3 -9 2 4
 */