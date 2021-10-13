package bytedanceyzp;

import java.util.Scanner;

public class Main3 {
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

            int[] state = new int[m];
            boolean flag = false;
            boolean flag2 = false;
            for (int i = 0; i < m; i++) {
                pq[i][0] = in.nextInt();
                boolean tag1 = false;
                boolean tag2 = false;

                if (pq[i][0] >= minX && pq[i][0] <= maxX) {
                    state[i] = 1;
                    tag1 = true;
                    flag = true;
                }
                pq[i][1] = in.nextInt();
                if (pq[i][1] >= minY && pq[i][0] <= minY) {
                    state[i] = 1;
                    tag2 = true;
                    flag = true;
                }
                if (tag1 && tag2) {
                    state[i] = 2;
                    flag2 = true;
                }
            }


            int sum = Integer.MAX_VALUE;
            int resX = 0, resY = 0;
            if (flag2) {
                for (int i = 0; i < m; i++) {
                    if (state[i] == 2) {
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
                }
            } else if (flag){
                for (int i = 0; i < m; i++) {
                    if (state[i] == 1) {
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
                }
            } else {
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