package yuanfudao;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] nums = new int[N][M+1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                nums[i][M] = nums[i][0];
            }
            int[][] dp = new int[N+1][M + 2];
            int[] sum = new int[M+1];
            for (int i = 0; i < M; i++) {
                sum[i] = 0;
                for (int j = 0; j < N; j++) {
                    sum[i] += nums[j][i];
                }
            }
            sum[M] = sum[0];
            int res = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M+1 ; j++) {
//                    Math.max()
//                    dp[i][j] = Math.max(sum[i], sum[i] + dp[i-1]);

                    res = Math.max(res, dp[i][j]);
                }
            }
            System.out.println(res);
        }
    }
}