package wangyiit;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int N = 10010;
            int[] T = new int[N];
            boolean[] used = new boolean[N];
            for (int i = 1; i <= m; i++) {
                T[i] = in.nextInt();
                used[T[i]] = true;
            }
            int[] a = new int[N];
            int j = 0;
            for (int i = 1; i < N; i++) {
                if (!used[i] && j < n - m) {
                    used[i] = true;
                    a[j] = i;
                }
            }

            int k = 0;
            j = 0;
            for (int i = 0; i < n; i++) {
//                if (k < )
            }
//            System.out.println(Arrays.toString(S));
        }
    }
}