package wangyigame;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int T = in.nextInt();
            for (int k = 0; k < T; k++) {


                int N = in.nextInt();
                HashMap<Integer, Integer> map = new HashMap<>();
                Deque<HashMap<Integer, int[]>> stack = new ArrayDeque<>();

                int[][] nums = new int[N][3];

                for (int i = 0; i < N; i++) {
                    nums[i][0] = in.nextInt();
                    nums[i][1] = in.nextInt();
                    nums[i][2] = in.nextInt();
                }
                for (int i = 0; i < N; i++) {
                    int time = nums[i][0];  // time
                    int id = nums[i][1];  // id
                    int s = nums[i][2];  // 0 1
                    HashMap<Integer, int[]> tempMap = new HashMap<>();

                    int useTime = 0;
                    boolean flag = false;
                    if (s == 1) {

                        while (!stack.isEmpty() && stack.peek().containsKey(1)) {
                            HashMap<Integer, int[]> top = stack.pop();
                            useTime += top.get(1)[1];
                            flag = true;
                        }

                        if (flag) {
                            HashMap<Integer, int[]> top = stack.pop();
                            time -= useTime;
                            int period = time - top.get(0)[1];
                            map.put(id, period);
                            tempMap.put(1, new int[]{id, period});
                            stack.push(tempMap);
                        }

                        while (!stack.isEmpty() && stack.peek().containsKey(0) && stack.peek().get(0)[0] == id) {
                            HashMap<Integer, int[]> top = stack.pop();
                            int period = time - top.get(0)[1];
                            map.put(id, period);
                            tempMap.put(1, new int[]{id, period});
                            stack.push(tempMap);
                        }


                    } else {
                        tempMap.put(s, new int[]{id, time});
                        stack.push(tempMap);
                    }
                }

                int res = Integer.MIN_VALUE;
                int index = 0;
                for (Integer key : map.keySet()) {
                    int temp = map.get(key);
                    if (temp > res) {
                        res = temp;
                        index = key;
                    }
                }

                System.out.println(index);
            }
        }
    }
}