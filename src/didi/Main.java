package didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int count;
    static List<int[]> res;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            count = 0;
            res = new ArrayList<>();
            visited = new boolean[10];
            dfs(0, new ArrayList<>());
            System.out.println(count);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i)[0] + " " + res.get(i)[1]);

            }
        }
    }

    private static void dfs(int index, ArrayList<Integer> list) {
        if (list.size() == 3 && verify(list)) {
            count++;
            res.add(getArray(list));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(index + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean verify(List<Integer> list) {
        int[] nums = getArray(list);
        return nums[0] + nums[1] == n;
    }

    private static int[] getArray(List<Integer> list) {
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        return new int[]{100 * a + 10 * b + c, 100 * a + 11 * c};
    }
}
