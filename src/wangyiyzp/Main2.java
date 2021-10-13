package wangyiyzp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int res;
    static int a;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list = new ArrayList<>();
            while (b != 0) {
                list.add(b % 10);
                b /= 10;
            }

            Collections.sort(list);

            if (list.get(list.size() - 1) < (a / (int) Math.pow(list.size()-1, 10))) {
                res = -1;
            } else {
                helper(list, 0, new ArrayList<>());
            }
        }
    }

    private static void helper(List<Integer> nums, int i, List<Integer> list) {
//        if (list.size() == nums.size() && getNum(list) > a) {
//            return;
//        }
    }

//    private static boolean getNum(List<Integer> list) {
//        return false;
//    }
}
