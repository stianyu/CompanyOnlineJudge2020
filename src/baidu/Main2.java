package baidu;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int T = in.nextInt();
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> res2 = new ArrayList<>();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                HashMap<Integer, Integer> map = new HashMap<>();
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int K = in.nextInt();
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < K; k++) {
                        int left = in.nextInt();
                        int right = in.nextInt();
                        for (int l = left; l <= right; l++) {
                            set.add(l);
                        }
                    }
                    for (int key : set) {
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                }
                for (int key : map.keySet()) {
                    if (map.get(key) == m) {
                        ans.add(key);
                    }
                }
                res.add(ans.size());
                res2.add(ans);
            }
            for (int i = 0; i < T; i++) {
                System.out.println(res.get(i));
                List<Integer> list = res2.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j == list.size() - 1) {
                        System.out.println(list.get(j));
                    } else {
                        System.out.print(list.get(j) + " ");
                    }
                }
            }
        }
    }
}
//2
//10 2
//3
//1 2
//1 2
//8 8
//2
//1 4
//6 8
//10 2
//3
//1 2
//4 5
//8 8
//2
//1 4
//6 8