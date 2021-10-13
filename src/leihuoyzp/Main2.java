package leihuoyzp;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int cur = in.nextInt();//1-N
            double downloadSpeed = in.nextDouble();
            double[] versionSize = new double[N+1];
            for (int i = 1; i <= N; i++) {
                versionSize[i] = in.nextDouble();
            }
            double[][] updateSize = new double[N][N + 1];
            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    updateSize[i][j] = in.nextDouble();
                }
            }
            double[][] updateTime = new double[N][N + 1];
            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    updateTime[i][j] = in.nextDouble();
                }
            }

            double[][] dp = new double[N+1][N+1];
            for (int i = cur; i < N; i++) {

            }
        }
    }
}

/*
3 1
1
1 2 3
1 2
1
1 2
1
 */