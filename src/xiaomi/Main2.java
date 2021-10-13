package xiaomi;
import java.util.Scanner;

public class Main2 {
    static boolean[][] visited = new boolean[3][4];
    static int[][] position = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) {
        char[][] chs = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String strs = in.nextLine();
            boolean flag = false;
            if (strs.length() != 0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (backTrack(chs, strs, 0, i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            System.out.println(flag);
        }
    }

    private static boolean backTrack(char[][] chs, String strs, int index, int i, int j) {
        if (index == strs.length() - 1) {
            return chs[i][j] == strs.charAt(index);
        }
        if (chs[i][j] == strs.charAt(index) && !visited[i][j]) {
            visited[i][j] = true;
            for (int[] pos : position) {
                int newI = i + pos[0];
                int newJ = j + pos[1];
                if (newI >= 0 && newI < 3 && newJ >= 0 && newJ < 4 && !visited[newI][newJ] && backTrack(chs, strs, index + 1, newI, newJ)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
