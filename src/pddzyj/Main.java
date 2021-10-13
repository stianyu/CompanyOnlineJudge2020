package pddzyj;

import java.util.*;

public class Main {
    static int[][] positions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m;
    static int n;
    static int tx;
    static int ty;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strings = in.nextLine().split(" ");
            m = Integer.parseInt(strings[0]);
            n = Integer.parseInt(strings[1]);
            char[][] map = new char[m][n];
            for (int i = 0; i < m; i++) {
                map[i] = in.nextLine().toCharArray();
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'T') {
                        tx = i;
                        ty = j;
                    }
                }
            }

            int minDeep = Integer.MAX_VALUE;
            List<int[]> lists = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'X') {
                        int temp = bfs(map, i, j);
//                        priorityQueue.offer(new Point(i, j, temp));
                        if (temp < minDeep) {
                            minDeep = temp;
                            lists.clear();
                            lists.add(new int[]{i, j});
                        } else if (temp == minDeep) {
                            lists.add(new int[]{i, j});
                        }
                    }
                }
            }

            System.out.println(minDeep);
        }
    }

    private static int bfs(char[][] map, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        int[][] shortestPath = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                shortestPath[k][l] = -1;
            }
        }

        queue.add(new int[]{i, j});
        shortestPath[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int[] position : positions) {
                int newX = pos[0] + position[0];
                int newY = pos[1] + position[1];
                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] == '0' &&
                        shortestPath[newX][newY] == -1) {
                    shortestPath[newX][newY] = shortestPath[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return shortestPath[tx][ty];
    }
}
/*
5 6
X00100
00000X
01T000
0X1010
00000X
 */

