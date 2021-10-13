package qianxin;

/**
 * 完全背包问题
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int amount = in.nextInt();
            int n = in.nextInt();
            int[] p = new int[n + 1];
            int[] w = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = in.nextInt();
                w[i] = in.nextInt();
            }
            System.out.println(helper(amount, n, p, w));

        }
    }

    private static int helper(int amount, int n, int[] p, int[] w) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = amount; j >= p[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - p[i]] + w[i]);
            }
        }
        return dp[amount];
    }
}
