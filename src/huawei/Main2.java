package huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[] depth = new int[N];
            for (int i = 0; i < N; i++) {
                depth[in.nextInt()]++;
            }
            long res = 1;
            for (int i = 1; i < N && depth[i] != 0; i++) {
                res = (res * comp(depth, i) % 1000000007) % 1000000007;

            }
            System.out.println(res);
        }
    }

    private static long comp(int[] depth, int i) {
        long res1 = 1;
        long res2 = 1;
        for (int j = i; j < depth[i]; j++) {
            res1 = (res1 * (2 * depth[i - 1] - j)) % 1000000007;
            res2 = (res2 * (j + 1)) % 1000000007;
        }
        return res1/res2 % 1000000007;
    }
}
