package tx;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] numNew = new int[n - 1];
            for (int i = 0; i < n; i++) {
                if(i==0){
                    System.arraycopy(nums,1,numNew,0,n-1);
                    Arrays.sort(numNew);
                    System.out.println(numNew[(n-1)/2]);
                }
                else if(i == n-1){
                    System.arraycopy(nums,0,numNew,0,n-1);
                    Arrays.sort(numNew);
                    System.out.println(numNew[(n-1)/2]);
                }
                else {
                    System.arraycopy(nums,0,numNew,0,i);
                    System.arraycopy(nums,i+1,numNew,i,n-1-i);
                    Arrays.sort(numNew);
                    System.out.println(numNew[(n-1)/2]);
                }
            }
        }
    }
}
