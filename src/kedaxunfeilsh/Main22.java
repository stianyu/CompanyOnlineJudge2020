package kedaxunfeilsh;

import java.util.Arrays;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String[] strings = in.nextLine().split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
//            mergeSort(nums);
            sort(nums);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    // 对arr[]数组中[start, end]的元素进行排序
    private static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid); // 先对[start, mid]排好序
        mergeSort(arr, mid + 1, end);  // 再对[mid + 1, end] 排序

        if (arr[mid] > arr[mid+1]) {  // 优化1：如果数据可能是近乎有序的数组，可以加一个判断。
            merge(arr, start, mid, end);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] array = Arrays.copyOfRange(arr, start, end + 1);
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if(i > mid) {
                arr[k] = array[j - start];
                j++;
            } else if (j > end) {
                arr[k] = array[i - start];
                i++;
            } else if (array[i - start] < array[j-start]) {
                arr[k] = array[i - start];
                i++;
            } else {
                arr[k] = array[j - start];
                j++;
            }

        }
    }

    private static void sort(int[] arr, int l, int r){
        if (l >= r) {
            return;
        }

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i] < v ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i] > v ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

