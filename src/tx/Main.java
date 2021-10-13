package tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums1 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] nums2 = new int[m];
            for (int i = 0; i < m; i++) {
                nums2[i] = in.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < n && j < m) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] > nums2[j]){
                    i++;
                } else {
                    j++;
                }
            }
            for (int k = 0; k < list.size(); k++) {
                if (k == list.size() - 1) {
                    System.out.println(list.get(k));
                } else {
                    System.out.print(list.get(k) + " ");
                }
            }
        }
    }
}
