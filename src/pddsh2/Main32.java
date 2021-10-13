package pddsh2;

import java.util.Scanner;

public class Main32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            int sum = 0;
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < n*m; i++) {
                if (sum > 0) {
                    sum += num[i%n];
                } else {
                    sum = num[i%n];
                }
                res = Math.max(res, sum);
            }
            System.out.println(res);
        }
    }
}

/*
5 3
1 3 -9 2 4

5 1
1 3 -9 2 4
 */