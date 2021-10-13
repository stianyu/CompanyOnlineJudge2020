package vivo;


import java.util.ArrayList;
import java.util.List;

class Graph {
    List<List<Integer>> adjList;
    int n;
    boolean directed;

    public Graph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        adjList.get(a).add(b);
        if (!directed) {
            adjList.get(b).add(a);
        }
    }


}

public class Main32 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序
     *
     * @param input string字符串
     * @return string字符串
     */
    public String compileSeq(String input) {
        // write code here
        String[] strs = input.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int n = nums.length;
        Graph graph = new Graph(n, true);
        List<Integer> srcList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != -1) {
                graph.addEdge(nums[i], i);
            } else {
                srcList.add(i);
            }
        }

        resList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int src : srcList) {
            dfs(graph, visited, src);
        }
        StringBuilder res = new StringBuilder();
        //res.append("\"");
        for (int i = 0; i < resList.size(); i++) {
            res.append(resList.get(i));
            if (i != resList.size() - 1) {
                res.append(",");
            }
        }
       // res.append("\"");
        return res.toString();
    }

    private List<Integer> resList;

    private void dfs(Graph graph, boolean[] visited, int src) {
        if (visited[src]) {
            return;
        }
        resList.add(src);
        visited[src] = true;
        List<Integer> adjs = graph.adjList.get(src);
        for (int adj : adjs) {
            dfs(graph, visited, adj);
        }
    }

    public static void main(String[] args) {
        Main32 s = new Main32();

        String res = s.compileSeq("1,2,-1,1");
        System.out.println(res);
    }

}