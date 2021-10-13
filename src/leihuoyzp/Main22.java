package leihuoyzp;

import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int j = in.nextInt();
            int i = in.nextInt();//1-N
            double t = in.nextDouble();
            double[] SV = new double[j+1];
            for (int m = 1; m <= j; m++) {
                SV[m] = in.nextDouble();
            }
            double[][] S = new double[j][j+1];
            for (int m = 1; m <= j - 1 ; m++) {
                for (int n = m+1; n <= j ; n++) {
                    S[m][n] = in.nextDouble();
                }
            }
            double[][] T = new double[j][j+1];
            for (int m = 1; m <= j - 1 ; m++) {
                for (int n = m+1; n <= j ; n++) {
                    T[m][n] = in.nextDouble();
                }
            }
            /*
                        i - > j
            t1升级：       Sij/t + Tij
            t2直接下载:    SVj/t
            t3升级到k再到j：Sik/t + Tik + Skj/t + Tkj
            t4降级到k再到j：SVk/t + Skj/t + Tkj
             */
            double res = 0;
            double t1 = S[i][j] / t + T[i][j];
            double t2 = SV[j] / t;

            int k = i;
            double t3 = Double.MAX_VALUE;
            while (++k < j) {
                t3 = Math.min(t3, S[i][k]/t + T[i][k] + S[k][j]/t + T[k][j]);
            }

            k = 0;
            double t4 = Double.MAX_VALUE;
            while (++k < j) {
                t4 = Math.min(t4, SV[k] / t + S[k][j] / t + T[k][j]);
            }

            res = Math.min(t1, Math.min(t2, Math.min(t3, t4)));
            System.out.println(res);
        }
    }
}
