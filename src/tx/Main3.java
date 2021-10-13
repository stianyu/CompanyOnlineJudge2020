package tx;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int k = Integer.parseInt(strs[1]);
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String string = in.nextLine();
                map.put(string, map.getOrDefault(string, 0) + 1);
            }
            TreeMap<Integer, String> map2 = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (String s : map.keySet()) {
                int times = map.get(s);
                map2.put(times, s);
            }
            int i = 0;
            for (int times : map2.keySet()) {
                i++;
                if (i < k) {
                    System.out.println(map2.get(times) + " " + times);
                } else {
                    break;
                }
            }
            TreeMap<Integer, String> map3 = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (String s : map.keySet()) {
                int times = map.get(s);
                map3.put(times, s);
            }
            for (int times : map3.keySet()) {
                System.out.println(map3.get(times) + " " + times);
            }
        }

    }
}
