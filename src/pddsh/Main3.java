package pddsh;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] f = new int[m+1];
            for( int i = 0; i < n; i++) {
                int c = in.nextInt();
                int v = in.nextInt();
                if (c > 0 && v > 0) {
                    for(int j = c; j <= m; j++) {
                        f[j] = Math.max(f[j], f[j-c] + v);
                    }
                }
            }
            System.out.println(f[m]);
        }
    }
}
