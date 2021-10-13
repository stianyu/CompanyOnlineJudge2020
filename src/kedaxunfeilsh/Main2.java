package kedaxunfeilsh;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String[] strings = in.nextLine().split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            quickSort2(nums);
        }
    }

    public static void quickSort2(int[] arr) {
        if (arr == null) {
            return;
        }

        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = partition2(arr, start, end);
        quickSort2(arr, start, p - 1);
        quickSort2(arr, p + 1, end);
//        System.out.println(Arrays.toString(arr));

    }

    private static int partition2(int[] arr, int start, int end) {
        int v = arr[start];
        int i = start + 1, j = end;

        while (true) {
            while (i <= end && arr[i] < v) i++;
            while (j >= start + 1 && arr[j] > v) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, start);

        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
/*
9
25,84,21,47,15,27,68,35,20
 */