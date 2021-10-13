package kedaxunfeilsh;

import java.util.Arrays;
import java.util.Scanner;

public class Main23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String[] strings = in.nextLine().split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i != nums.length - 1) {
                    System.out.println(nums[i] + ",");
                } else {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
