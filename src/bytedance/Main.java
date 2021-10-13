package bytedance;

//08.08
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] nums = new int[10000];
            for (int i = 1; i <= n; i++) {
                nums[i] = in.nextInt();
            }

            int[][] dp = new int[10000][10000];
            for (int i = 1; i <= n; i++) {
                dp[i][i] = nums[i];
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                int tempMax = nums[i];
                for (int j = i; j <= n; j++) {
                    if ((j - i) % 2 == 0) {
                        dp[i][j] = Math.max(nums[j], dp[i][j-1] + nums[j]);
                    } else {
                        dp[i][j] = Math.max(-nums[j], dp[i][j-1] - nums[j]);
                    }
                    tempMax = Math.max(tempMax, dp[i][j]);
                }
                max = Math.max(max, tempMax);
            }

            System.out.println(max);
        }
    }
}