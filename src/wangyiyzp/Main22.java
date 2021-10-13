package wangyiyzp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            List<Integer> nums1 = getNums(a);
            List<Integer> nums2 = getNums(b);
            Collections.sort(nums2);

            boolean flag = false;

            for (int i = 0; i < nums1.size(); i++) {
                int j = i;
                while (j < len && nums1.get(i) > nums2.get(j)) {
                    j++;
                }
                if (j >= len) {
                    flag = true;
                    break;
                } else {
                    swap(nums2, i, j);
                }
            }
            if (flag) {
                System.out.println(-1);
            } else {
                int sum = 0;
                for (int i = nums2.size() - 1; i >= 0 ; i--) {
                    sum = sum * 10 + nums2.get(i);
                }
                System.out.println(sum);
            }

        }
    }

    public static List<Integer> getNums(int a) {
        List<Integer> list = new ArrayList<>();
        while (a != 0) {
            list.add(a % 10);
            a /= 10;
        }
        return list;
    }

    public static void swap(List<Integer> nums2, int i, int j) {
        int temp = nums2.get(i);
        nums2.set(i, nums2.get(j));
        nums2.set(j, temp);
    }
}
