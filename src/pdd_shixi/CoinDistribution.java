package pdd_shixi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 拼多多服务端开发实习生机试-2020.06.02
 * 第三题：
 *      有 N 个人，每个人有 Ci 个硬币。
 *      如果有最多硬币的人比有最少硬币的人的糖果数大于 1，则最多硬币的人给一枚硬币给最少糖果的人，以上算一次糖果的分配。
 *      一共分配 K 次，求进行 K 次分配后，最大硬币数比最小硬币数的差是多少。
 *      输入：
 *          3 1        N K
 *          1，1，4    C1 C2 …… CN
 *      输出：
 *          2
 */
public class CoinDistribution {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
        	String[] lineArr1 = in.nextLine().split(" ");
            int n = Integer.parseInt(lineArr1[0]);
            int m = Integer.parseInt(lineArr1[1]);
            int[] candy = new int[n];
            String[] lineArr2 = in.nextLine().split(" ");
            for(int i = 0; i < n; i++) {
            	candy[i] = Integer.parseInt(lineArr2[i]);
            }
            for(int i = 0; i < m; i++) {
            	Arrays.sort(candy);
            	if(candy[n-1] - candy[0] > 1) {
            		candy[n-1] -= 1;
            		candy[0] += 1;
            	}
            }
            Arrays.sort(candy);
            System.out.println(candy[n - 1] - candy[0]);
            
        }
    }

}
