package wangyiyzp;

import java.util.*;

public class Main23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            int[] nums1 = getNums(a, len);
            int[] nums2 = getNums(b, len);
            Arrays.sort(nums2);

            boolean flag = false;

            for (int i = 0; i < nums1.length; i++) {
                int j = i;
                while (j < len && nums1[i] > nums2[j]) {
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
                for (int i = len - 1; i >= 0 ; i--) {
                    sum = sum * 10 + nums2[i];
                }
                System.out.println(sum);
            }

        }
    }

    public static int[] getNums(int a, int len) {
        int[] list = new int[len];
        int i = len-1;
        while (a != 0) {
            list[i--] = a % 10;
            a /= 10;
        }
        return list;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
