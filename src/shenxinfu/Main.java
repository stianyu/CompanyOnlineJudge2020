package shenxinfu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                sum += temp;
                max = Math.max(temp, max);
            }
            int y = max + 1;
            int res = 0;
            while (((y * n - sum) <= 0) || (y * n - sum) - (n - 1) * (int) ((y * n - sum) / (n - 1)) > 0) {
                y++;
            }
            res = (y * n - sum) / (n - 1);
            System.out.println(res);
        }
    }
}

/*
3
1 2 3
 */