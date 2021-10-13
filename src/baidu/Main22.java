package baidu;
import java.util.*;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            int[] answer_n = new int[T];
            List<List<Integer>> answer = new ArrayList<List<Integer>>();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                List<Integer> ans = new ArrayList<Integer>();
                for (int j = 0; j < m; j++) {
                    int K = in.nextInt();
                    for (int k = 0; k < K; k++) {
                        int left = in.nextInt();
                        int right = in.nextInt();
                        for (int l = left; l <= right; l++) {
                            if (map.containsKey(l)) {
                                map.put(l, map.get(l) + 1);
                            } else {
                                map.put(l, 1);
                            }
                        }
                    }
                }
                for (int temp : map.keySet()) {
                    if (map.get(temp) == m) {
                        ans.add(temp);
                    }
                }
                int sum = ans.size();
                answer_n[i] = sum;
                answer.add(ans);
            }
            for (int i = 0; i < T; i++) {
                System.out.println(answer_n[i]);
                int count = answer.get(i).size();
                for (int j = 0; j < count; j++) {

                    System.out.print(answer.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
