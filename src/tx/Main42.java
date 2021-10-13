import java.util.*;

public class Main42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int[] copy = new int[n-1];
            for (int i = 0; i < n ; i++) {
                if(i==0){
                    System.arraycopy(a,1,copy,0,n-1);
                    Arrays.sort(copy);
                    System.out.println(copy[(n-1)/2]);
                }
                else if(i == n-1){
                    System.arraycopy(a,0,copy,0,n-1);
                    Arrays.sort(copy);
                    System.out.println(copy[(n-1)/2]);
                }
                else {
                    System.arraycopy(a,0,copy,0,i);
                    System.arraycopy(a,i+1,copy,i,n-1-i);
                    Arrays.sort(copy);
                    System.out.println(copy[(n-1)/2]);
                }
            }
        }
    }
}