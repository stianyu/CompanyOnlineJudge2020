package zijiezl;

import java.util.*;

public class T42 {
    static List<Integer> list;
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

            list = new ArrayList<>();
            helper(nums, 0, 0);
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            System.out.println(list.get(k-1) + " " + list.get(0));

//            for (Integer key : list) {
//                System.out.println(key + " ");
//            }
        }
    }

    private static void helper(int[][] nums, int index, int sum) {
        if (index == nums.length) {
            list.add(sum);
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