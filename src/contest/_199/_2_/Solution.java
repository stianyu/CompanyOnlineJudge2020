package contest._199._2_;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        // 建邻接表
        ArrayList<Integer>[] table = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new ArrayList<>();
        }
        char[] chs = labels.toCharArray();
        for (int i = 0; i < edges.length; i++) {
            table[edges[i][0]].add(edges[i][1]);
        }

        // 遍历邻接表获得该 table[index] 为根节点的所有子树的重复字符个数和
        for (int i = 0; i < n; i++) {
            res[i] = dfs(table, i, n, chs, chs[i], 0);
        }
        return res;
    }

    //从table[index] 开始搜所有孩子里和index位置字符相同的个数，应该为每个孩子的个数的总和
    private int dfs(ArrayList<Integer>[] table, int index, int n, char[] chs, char thisC, int count) {
        if(table[index].size() == 0) {
            if (chs[index] == thisC) {
                return count+1;
            }
            return count;
        }

        int temp = count;
        ArrayList<Integer> list = table[index];
        for (int i = 0; i < list.size(); i++) {
            count += dfs(table, list.get(i), n, chs, thisC, temp);
        }

        if (chs[index] == thisC) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
//        int n = 7;
//        int[][] edges = {{0,1}, {0,2}, {2,3},{2,6},{1,5},{1,4}};
//        String labels = "abaedcd";
        int n = 4;
        int[][] edges = {{0,1}, {0,3}, {1,2}};
        String labels = "bbbb";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countSubTrees(n, edges, labels)));
    }
}
