package qianxin;

import java.util.*;

/**
 * 全排列问题
 */
public class Main2 {
    static List<List<Integer>> res;
    static boolean[] visited;
    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    public static int reletive_7 (int[] digit) {
        // write code here
        Arrays.sort(digit);
        res = new ArrayList<>();
        visited = new boolean[digit.length];
        helper(digit, 0, new ArrayList<Integer>());
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[");
            if (i != res.size() - 1) {
                printlnList(res.get(i));
            }else {
                printlnList(res.get(i));
            }
            System.out.println("]");
        }
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            int sum = 0;
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                sum = sum * 10 + list.get(j);
            }
            System.out.println(sum);
            if (sum % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    private static void helper(int[] digit, int index, ArrayList<Integer> list) {
        if (list.size() == digit.length) {
            res.add(new ArrayList<Integer>(list));
//            int result = res.get()
            return;
        }

        for (int i = 0; i < digit.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(digit[i]);
                helper(digit, index+1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void printlnList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ",");
            } else {
                System.out.print(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        int[] digit = {1,1,2};
        System.out.println(reletive_7(digit));
    }
}
