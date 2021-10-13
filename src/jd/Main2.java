package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int op = in.nextInt();
                if (op == 1) {
                    int pos = in.nextInt();
                    int value = in.nextInt();
                    sb.insert(pos - 1, value);
                } else if (op == 2) {
                    int delPos = in.nextInt();
                    sb.delete(delPos - 1, delPos);
                } else {
                    String str = new String(sb);
                    res.add(str);

                }
            }
            for (int i = 0; i < res.size(); i++) {
                String str = res.get(i);
                for (int j = 0; j < str.length(); j++) {
                    if (j != str.length() - 1) {
                        System.out.print(str.charAt(j) + " ");
                    } else {
                        System.out.println(str.charAt(j));
                    }
                }
            }
        }
    }
}
