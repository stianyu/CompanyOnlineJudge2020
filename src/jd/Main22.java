package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> res1 = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int op = in.nextInt();
                if (op == 1) {
                    int pos = in.nextInt();
                    int value = in.nextInt();
                    if (res.size() == 0) {
                        res.add(value);
                    } else {
                        if (pos > res.size()) {
                            res.add(value);
                        } else {
                            res.add(pos-1, value);
                        }
                    }
                } else if (op == 2) {
                    int delPos = in.nextInt();
                    res.remove(delPos - 1);
                } else {
                    res1.add(res);

                }
            }
            for (int i = 0; i < res1.size(); i++) {
                if (i != res1.size()) {
//                    ArrayList<Integer>
                    for (int j = 0; j < res.size(); j++) {
                        if (j != res.size() - 1) {
                            System.out.print(res.get(j) + " ");
                        } else {
                            System.out.println(res.get(j));
                        }
                    }
                }

            }
        }
    }
}
