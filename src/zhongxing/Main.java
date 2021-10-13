package zhongxing;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            int[] dp = new int[n+1];
            int count = 0;
            int max = b[0];  // a[i] 中的最大值
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                if (b[j] > max) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if (a[i] > b[j]) {
                        count++;
                    }
//                    if (max)
                }

            }
            System.out.println(count);
        }
    }
}
