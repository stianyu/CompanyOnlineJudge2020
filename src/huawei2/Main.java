package huawei2;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length;
        int[] numNew = new int[len1 + len2];

        int index = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                numNew[index++] = nums1[i++];
            } else {
                numNew[index++] = nums2[j++];
            }
        }

        while (j < len2) {
            numNew[index++] = nums2[j++];
        }
        while (i < len1) {
            numNew[index++] = nums1[i++];
        }

        if ((len1 + len2) % 2 == 0) {
            return (numNew[(len1 + len2) / 2] + numNew[(len1 + len2) / 2 - 1]) / 2.0;
        } else {
            return numNew[(len1 + len2) / 2];
        }
    }
}
