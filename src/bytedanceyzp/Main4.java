package bytedanceyzp;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] xy = new int[n][2];
            int[][] pq = new int[m][2];
            int minX = Integer.MIN_VALUE, maxX = Integer.MAX_VALUE;
            int minY = Integer.MIN_VALUE, maxY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                xy[i][0] = in.nextInt();
                minX = Math.min(minX, xy[i][0]);
                maxX = Math.max(maxX, xy[i][0]);
                xy[i][1] = in.nextInt();
                minY = Math.min(minY, xy[i][1]);
                maxY = Math.max(maxY, xy[i][1]);
            }

            for (int i = 0; i < m; i++) {
                pq[i][0] = in.nextInt();
                pq[i][1] = in.nextInt();
            }

            int sum = Integer.MAX_VALUE;
            int resX = 0, resY = 0;
                for (int i = 0; i < m; i++) {
                        int temp = 0;
                        for (int j = 0; j < n; j++) {
                            temp += Math.abs(pq[i][0] - xy[j][0]) + Math.abs(pq[i][1] - xy[j][1]);
                        }
                        if (temp < sum) {
                            resX = pq[i][0];
                            resY = pq[i][1];
                            sum = temp;
                        }
                }

            System.out.println(resX + " " + resY);
        }
    }
}

/*
4 3
-1 -1
-1 1
1 -1
1 1
3 2
1 0
0 0
 */