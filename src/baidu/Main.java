package baidu;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] a = new int[n];
            int zero  = 0;
            int five = 0;
            for (int i = 0; i < n; i++) {
                if (in.nextInt() == 5) {
                    five++;
                } else {
                    zero++;
                }
            }
            if (zero == 0) {
                System.out.println(-1);
            } else if (five < 9){
                System.out.println(0);
            } else {
                System.out.println(helper(five, zero));
            }
        }
    }

    private static String helper(int five, int zero) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < five/9; i++) {
            sb.append("555555555");
        }
        for (int i = 0; i < zero; i++) {
            sb.append("0");
        }

        return sb.toString();
    }
}
