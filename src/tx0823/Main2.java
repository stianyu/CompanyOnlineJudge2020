package tx0823;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int k = Integer.parseInt(in.nextLine());

            Map<Character, Integer> map = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int count = k;
            StringBuilder sb = new StringBuilder();
            for (Character c : map.keySet()) {
                if (count > 0) {
                    int numC = map.get(c);
                    int times = 0;
                    if (count >= numC) {
                        count -= numC;
                        times = numC;
                    } else {
                        times = count;
                        count = 0;
                    }
                    for (int i = 0; i < times; i++) {
                        sb.append(c);
                    }
                } else {
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}
