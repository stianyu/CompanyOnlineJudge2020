package pddsh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] res = new int[n][n];
            int rightX = n-1, rightY = 0;
            int leftX = 0, leftY = n - 1;
            while (rightX >= leftX && rightY <= leftY) {
                help(res, rightX--, rightY++, leftX++, leftY--);
            }

        }
    }

    private static void help(int[][] res, int rx, int ry, int lx, int ly) {
//        if (rx - lx + 1)
    }
}
