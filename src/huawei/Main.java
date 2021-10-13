package huawei;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
// 顺时针打印矩阵
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static List<int[]> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int m = in.nextInt();
            int n = in.nextInt();
            if (m < 0 || n < 0) {
                System.out.println("[]");
            } else {
                list = new ArrayList<>();
                helper(m, n);
                System.out.print("[");
                for (int i = 0; i < list.size(); i++) {
                    int[] position = list.get(i);
                    if (i != list.size() - 1) {
                        System.out.print("[" + position[0] + "," + position[1] + "],");
                    } else {
                        System.out.print("[" + position[0] + "," + position[1] + "]");
                    }
                }
                System.out.print("]");
            }
        }
    }

    public static void helper(int m, int n) {
        int l = 0, r = n - 1, t = 0, d = m - 1;
        int count = 0;
        while (true) {
            for (int i = l; t <= d && i <= r ; i++) {
                count++;
                if (verify(count)) {
                    list.add(new int[]{t, i});
                }
            }
            t++;
            for (int i = t; l <= r && i <= d; i++) {
                count++;
                if (verify(count)) {
                    list.add(new int[]{i, r});
                }
            }
            r--;
            for (int i = r; t <= d && i >= l ; i--) {
                count++;
                if (verify(count)) {
                    list.add(new int[]{d, i});
                }
            }
            d--;
            for (int i = d; l <= r && i >= t; i--) {
                count++;
                if (verify(count)) {
                    list.add(new int[]{i, l});
                }
            }
            l++;
            if (count == m * n) {
                break;
            }
        }
    }

    public static boolean verify(int count) {
        int f1 = count % 10;
        int f2 = count % 100 / 10;
        if (f1 == 7 && f2 % 2 == 1) {
            return true;
        }
        return false;
    }
}