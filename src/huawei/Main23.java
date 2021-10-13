package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class Main23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            int[] deep = new int[n];
            for(int i=0 ; i<n ; i++){
                deep[i] = scan.nextInt();
            }
            System.out.println(count(deep , n));
        }
    }
    public static int count(int[] deep , int n ){
        TreeMap<Integer , Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0 ; i<n; i++){
            if(map.containsKey(deep[i])){
                map.put(deep[i] , map.get(deep[i]) + 1);
            }
            else{
                map.put(deep[i] , 1);
            }
        }
        int count = 1;
        for(int cur : map.keySet()) {
            if(cur > 0){
                if(map.get(cur)< (map.get(cur-1) * 2)){
                    count *= Cab(map.get(cur-1) * 2 , map.get(cur));
                }
            }
        }

        return count % 1000000007;

    }
    public static int Cab(int a , int b){
        int big = 1 , small = 1;
        for(int i=0 ; i<b ; i++){
            big = big * a;
            a--;
        }
        while(b > 0){
            small = small * b;
            b--;
        }
        return big / small;
    }
}