package vivo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int[][] positions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            n = Integer.parseInt(in.nextLine());
            String[] strings = in.nextLine().split(" ");
            int beginX = Integer.parseInt(strings[0]);
            int beginY = Integer.parseInt(strings[1]);
            int endX = Integer.parseInt(strings[2]);
            int endY = Integer.parseInt(strings[3]);
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                char[] temp = in.nextLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    if (temp[j] == '#' || temp[j] == '@') {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            visited = new boolean[n][n];
            System.out.println(help(map, beginX, beginY, endX, endY));
        }
    }

    private static int help(int[][] map, int beginX, int beginY, int endX, int endY) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{beginX, beginY});

        int res = 1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int[] position : positions) {
                int newX = temp[0] + position[0];
                int newY = temp[1] + position[1];
                if (newX > 0 && newX < n && newY > 0 && newY < n && !visited[newX][newY] && map[newX][newY] != 1) {
                    queue.add(new int[]{newX, newY});
                    res++;
                }
            }
        }

        return res;
    }


}
/*
15
0 7 7 7
*5#++B+B+++++$3
55#+++++++###$$
###$++++++#+*#+
++$@$+++$$$3+#+
+++$$+++$+4###+
A++++###$@+$++A
+++++#++$#$$+++
A++++#+5+#+++++
+++$$#$++#++++A
+++$+@$###+++++
+###4+$+++$$+++
+#+3$$$+++$##++
+#*+#++++++#$$+
$####+++++++$##
3$+++B++B++++#5
 */