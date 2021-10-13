package aiqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int[][] nums = new int[N][2];
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                nums[i][0] = in.nextInt();
                minX = Math.min(minX, nums[i][0]);
                maxX = Math.max(maxX, nums[i][0]);
                nums[i][1] = in.nextInt();
                minY = Math.min(minY, nums[i][1]);
                maxY = Math.max(maxY, nums[i][1]);
            }
            int res = Integer.MAX_VALUE;
            int resX = 0;
            int resY = 0;
            for (int i = minX; i <= maxX; i++) {
                for (int j = minY; j <= maxY; j++) {
                    int sum = calSum(i, j, N, nums);
                    if (sum < res) {
                        res = sum;
                        resX = i;
                        resY = j;
                    }
                }
            }
            System.out.println(resX + " " + resY + " " + res);
        }
    }

    private static int calSum(int i, int j, int N, int[][] nums) {
        int sum = 0;
        for (int k = 0; k < N; k++) {
            sum += Math.abs(i - nums[k][0]) + Math.abs(j - nums[k][1]);
        }
        return sum;
    }
}
