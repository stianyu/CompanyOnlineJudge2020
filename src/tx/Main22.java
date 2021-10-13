package tx;

import java.util.*;

public class Main22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int i = 0;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                for (int k = 0; k < x; k++) {
                    int temp = in.nextInt();
                    if (!list.contains(temp)) {
                        list.add(temp);
                    }
                }
            }
        }
    }

}
