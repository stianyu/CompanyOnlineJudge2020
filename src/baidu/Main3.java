package baidu;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            if (m == 1) {
                System.out.println(1);
            } else if (m == 2){
                if (n == 1) {
                    System.out.println(1);
                } else if (n == 2) {
                    System.out.println(2);
                } else {
                    long first = 1;
                    long second = 2;
                    long res = 0;
                    for (int i = 3; i <= n; i++) {
                        res = (first + second) % 10000007;
                        first = second;
                        second = res;
                    }
                    System.out.println(res);
                }
            }
        }
    }
}