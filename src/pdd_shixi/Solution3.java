package pdd_shixi;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Map<Integer, Integer> hashMap = new HashMap<>();//键：硬币数，值：持有对应硬币数的玩家数
            int min = Integer.MAX_VALUE;//最大硬币数
            int max = Integer.MIN_VALUE;//最小硬币数
            for (int i = 0; i < N; i++) {
                int coin = sc.nextInt();
                min = Math.min(min, coin);
                max = Math.max(max, coin);
                hashMap.put(coin, hashMap.getOrDefault(coin, 0) + 1);
            }
            for (int i = 0; i < M; i++) {
                if (max - min > 1) {
                    //最大硬币数玩家硬币数-1，对应max-1的key的值+1
                    hashMap.put(max - 1, hashMap.getOrDefault(max - 1, 0) + 1);
                    int oldMaxCount = hashMap.get(max);
                    if (oldMaxCount == 1) {
                        hashMap.remove(max);
                        max--;
                    } else {
                        hashMap.put(max, oldMaxCount - 1);
                    }
                    //旧的max对应的值减一，减到0去除这个key
                    hashMap.put(min + 1, hashMap.getOrDefault(min + 1, 0) + 1);
                    int OldMinCount = hashMap.get(min);
                    if (OldMinCount == 1) {
                        hashMap.remove(min);
                        min++;
                    } else {
                        hashMap.put(min, OldMinCount - 1);
                    }
                }
            }
            System.out.println(max - min);
        }
        sc.close();
    }
}
