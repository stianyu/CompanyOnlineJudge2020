package aiqiyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] girls = in.nextLine().split(" ");
            String[] boys = in.nextLine().split(" ");

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < girls.length; i++) {
                map.put(girls[i], map.getOrDefault(girls[i], 0) + 1);
            }

            int count = 0;
            for (int i = 0; i < boys.length; i++) {
                if (map.getOrDefault(boys[i], 0) == 0) {
                    count++;
                } else {
                    map.put(boys[i], map.get(boys[i]) - 1);
                    if (map.get(boys[i]) == 0) {
                        map.remove(boys[i]);
                    }
                }
            }

            System.out.println(count);
        }
    }
}
