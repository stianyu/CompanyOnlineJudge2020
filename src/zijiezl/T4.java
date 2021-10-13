package zijiezl;

import java.util.*;

public class T4 {
    static Map<Integer, Integer> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = in.nextInt();
                }
            }

            map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            helper(nums, 0, 0);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Iterator<Integer> it = map.keySet().iterator();
            while (k != 0 && it.hasNext()) {
                int temp = it.next();
                max = Math.max(max, temp);
                min = Math.min(min, temp);
                k -= map.get(temp);
            }
            System.out.println(min + " " + max);
//            for(Iterator<Integer> it2 = map.keySet().iterator(); it2.hasNext();) {
//                Integer key = it2.next();
//                System.out.println(key + " : " + map.get(key));
//            }
        }
    }

    private static void helper(int[][] nums, int index, int sum) {
        if (index == nums.length) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[index][i];
            helper(nums, index+1, sum);
            sum -= nums[index][i];
        }
    }
}

/*
3 3 1
3 1 2
2 3 4
3 6 4

3 3 3
3 1 2
2 3 4
3 6 4
 */