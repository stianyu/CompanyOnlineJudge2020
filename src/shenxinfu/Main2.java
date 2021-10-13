package shenxinfu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(i, list);
            }
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
//                map.get(b).add(a)
            }
        }
    }
}
