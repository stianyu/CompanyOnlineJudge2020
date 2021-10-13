package meituan;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            HashMap<String, String> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                String[] strs = in.nextLine().split(" ");
                String begin = strs[0];
                String end = strs[1];
                if (map.containsKey(end)) {
                    count++;
//                    while (!map.isEmpty())
//                        map.remove(0);
                    map.clear();
                    continue;
                }
                map.put(begin, end);
            }
            System.out.println(count);
        }
    }
}
