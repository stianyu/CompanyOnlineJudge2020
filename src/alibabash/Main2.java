package alibabash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static int count;
    static boolean[] visited;
//    static List<List<Integer>> res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
//            res = new ArrayList<>();
            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }
            Collections.sort(list);
            visited = new boolean[list.size()];
            dfs(list, 0, new ArrayList<>(), n);
            System.out.println(count);
//            System.out.println(res);
        }
    }

    private static void dfs(List<Integer> listNum, int index, List<Integer> list, int n) {
        if (list.size() == listNum.size()) {
            int sum = getNum(list);
//            res.add(new ArrayList<>(list));
            if (sum != -1 && sum % n == 0) {
                count++;
            }
            return;
        }
        for (int i = 0; i < listNum.size(); i++) {
//            if (list.size() == 0 && listNum.get(i) == 0) continue;
            if (!visited[i]) {
                if (i > 0 && listNum.get(i) == listNum.get(i-1) && !visited[i-1]) continue;
                list.add(listNum.get(i));
                visited[i] = true;
                dfs(listNum, i+1, list, n);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static int getNum(List<Integer> list) {
        int sum = 0;
        if (list.get(0) == 0) {
            return -1;
        }
        for (Integer num : list) {
            sum = sum * 10 + num;
        }

        return sum;
    }

}
