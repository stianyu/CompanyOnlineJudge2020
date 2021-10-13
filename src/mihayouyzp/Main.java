package mihayouyzp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char[][] chs = new char[m][n];
            int cnt = 0;
            int u = 0, d = m - 1;
            int l = 0, r = n - 1;
            while(true) {
                for(int i = l; i <= r; i++) {
                    chs[u][i] = alpha.charAt(cnt++ % 26);
                }
                if(++u > d) break;
                for(int i = u; i <= d; i++) {
                    chs[i][r] = alpha.charAt(cnt++ % 26);
                }
                if(--r < l) break;
                for(int i = r; i >= l; i--) {
                    chs[d][i] = alpha.charAt(cnt++ % 26);
                }
                if(--d < u) break;
                for(int i = d; i >= u; i-- ) {
                    chs[i][l] = alpha.charAt(cnt++ % 26);
                }
                if(++l > r) break;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chs[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
