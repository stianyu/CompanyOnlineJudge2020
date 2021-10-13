
package tx0823;
/*
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int T = in.nextInt();
            for (int k = 0; k < T; k++) {
                int n = in.nextInt();

                HashMap<Integer, Integer> map = new HashMap<>();
                int res = 0;
                for (int i = 1; i < n; i++) {
                    if (map.containsKey(i)) {
                        break;
                    } else {
                        map.put(n - i, i);
                        res = Math.max(res, helper(i, n - i));
                    }
                }

                System.out.print(res + " ");
            }
        }
    }

    private static int helper(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int T = in.nextInt();
            int n = in.nextInt();
            for (int i = 0; i < T; i++) {
                List<Integer> nums = getNums(n);
                int sum = 0;
                for (int j = 0; j < nums.size() - 1; j++) {
                    sum += nums.get(i);
                }
                sum += 9 * (nums.size() - 1) + nums.get(nums.size() - 1);
                System.out.println(sum);
            }
        }
    }

    private static List<Integer> getNums(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list;
    }
}
