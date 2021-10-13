package yuanfudao;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int N = in.nextInt();
            int[] tree = new int[N+1];
            for (int i = 1; i <= N; i++) {
                tree[i] = in.nextInt();
            }
            int depth = 0;
            int temp = N;
            while (temp > 0) {
                temp /= 2;
                depth++;
            }
            List<Integer> list = new ArrayList<>();
            if ((1 << depth) - 1 > N ) {
                for (int i = 1; i <= depth; i++) {
                    list.add(tree[1 << (i - 1)]);
                }
                int start = (1 << (depth - 1)) + 1;
                for (int i = start; i <= N; i++) {
                    list.add(tree[i]);
                }
                for (int i = N / 2 + 1; i <= (1 << (depth - 1)) - 1; i++) {
                    list.add(tree[i]);
                }
                for (int i = depth - 2; i > 1 ; i--) {
                    list.add(tree[(1 << i) - 1]);
                }
            } else {
                for (int i = 1; i <= depth; i++) {
                    list.add(tree[1 << (i - 1)]);
                }
                int start = (1 << (depth - 1)) + 1;
                for (int i = start; i <= N; i++) {
                    list.add(tree[i]);
                }
                for (int i = depth - 1; i > 1 ; i--) {
                    list.add(tree[(1 << i) - 1]);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    System.out.print(list.get(i) + " ");
                } else {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}

/*
19
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
 */