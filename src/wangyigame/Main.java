package wangyigame;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int T = Integer.parseInt(in.nextLine());
            for (int i = 0; i < T; i++) {
                String[] strs = in.nextLine().split(" ");
                int[] num = new int[10];
                int[] group = new int[26];
                for (int j = 0; j < 7; j++) {
                    System.out.println(strs[j].charAt(0));
                    num[strs[j].charAt(0) - '0']++;
                    group[strs[j].charAt(1) - 'A']++;

                }
                int count = 0;
                boolean flag = true;
                for (int j = 1; j <= 9; j++) {
                    if (count > 2) {
                        flag = false;
                        break;
                    }
                    if (num[j] == 0) {
                        count++;
                    }
                }

                if (!flag) {
                    int s = 0;
                    for (int j = 0; j < 26; j++) {
                        if (group[j] == 0) {
                            continue;
                        }
                        if (group[j] > 3 || s > 2) {
                            flag = false;
                            break;
                        }
                        s += 3 - group[j];
                    }
                }

                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}