package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[] depth = new int[N];
            for (int i = 0; i < N; i++) {
                depth[i] = in.nextInt();
            }
            long res = comp(depth, N);
            System.out.println(res);
        }
    }

    private static long comp(int[] depth, int n) {
        Arrays.sort(depth);
        int cur = 1;
        long count = 1;
        while (cur < n) {
            if (cur == n - 1) {
                count *= 2;
                cur++;
            } else if (depth[cur] != depth[cur + 1]) {
                count *= 2;
                cur++;
            } else {
                cur = cur + 2;
            }
        }
        return count % 1000000007;
    }
}
