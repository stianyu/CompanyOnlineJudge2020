package vivo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//70%
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] l = sc.nextLine().split(" ");
            int srcX = Integer.parseInt(l[0]);
            int srcY = Integer.parseInt(l[1]);
            int tarX = Integer.parseInt(l[2]);
            int tarY = Integer.parseInt(l[3]);
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                char[] chars = line.toCharArray();
                for (int j = 0; j < n; j++) {
                    char c = chars[j];
                    grid[i][j] = (c == '#' || c == '@') ? 0 : 1;
                }
            }
            int res = solve(grid, srcX, srcY, tarX, tarY);
            System.out.println(res);
        }
        sc.close();
    }

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int solve(int[][] grid, int srcX, int srcY, int tarX, int tarY) {
        int n = grid.length;
        int[][] shortestPath = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shortestPath[i][j] = Integer.MIN_VALUE;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>(n * n);
        queue.add(new int[]{srcX, srcY});
        shortestPath[srcX][srcY] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && grid[nx][ny] == 1
                        && shortestPath[nx][ny] == Integer.MIN_VALUE) {
                    queue.add(new int[]{nx, ny});
                    shortestPath[nx][ny] = shortestPath[x][y] + 1;
                }
            }
        }
        return shortestPath[tarX][tarY];
    }
}
