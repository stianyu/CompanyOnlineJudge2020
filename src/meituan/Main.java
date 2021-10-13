package meituan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int count = 0;
            HashMap<Integer, Integer> res = new HashMap<>();
            for (int i = 2177; i < N; i++) {
                int t = i % 10;
                if (i != 1 && t % 2 != 0) {
                    continue;
                }
                int temp = i * 4;
                List<Integer> list = getNums(temp);
                List<Integer> list2 = getNums(i);
                if (list.size() != list2.size()) {
                    continue;
                }
                boolean flag = true;
                for (int j = 0, k = list2.size() - 1; j < list.size(); j++, k--) {
                    if (list.get(j) != list2.get(k)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                    res.put(i, temp);
                }
            }
            if (count == 0) {
                System.out.println(0);
            } else {
                System.out.println(count);
                for (Integer key : res.keySet()) {
                    System.out.println(key + " " + res.get(key));
                }
            }
        }
    }

    public static List<Integer> getNums(int temp) {
        List<Integer> list = new LinkedList<>();
        while(temp != 0) {
            int tail = temp % 10;
            temp /= 10;
            list.add(tail);
        }
        return list;
    }
}
