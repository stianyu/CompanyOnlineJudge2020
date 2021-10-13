package didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int count = 0;
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (j == i || k == i || k == j) {
                            continue;
                        }
                        if (200 * i + 10 * j + 12 * k == n) {
                            count++;
                            res.add(getArray(i, j, k));
                        }
                    }
                }

            }
            System.out.println(count);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i)[0] + " " + res.get(i)[1]);

            }
        }
    }

    private static int[] getArray(int a, int b, int c) {
        return new int[]{100 * a + 10 * b + c, 100 * a + 11 * c};
    }
}
