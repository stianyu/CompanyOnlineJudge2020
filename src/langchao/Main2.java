package langchao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 某条街道两侧分别种植了一排树木，并按如下编号：
 * 1 3 5 7 .... 45 47 49 ... 99
 * 2 4 6 8 ... 46 48 50 ... 100
 * 但是有一些树被砍去，希望你能找出一边最长的连续的大树。
 *
 * 输入描述
 * 第一行一个整数N
 * 第二行N个整数表示被砍去树的编号
 *
 * 输出描述
 * M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）\
 *
 * 样例输入
 * 5
 * 9 15 27 35 6
 * 样例输出
 * 8 47
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] odd = new int[n];
            int[] even = new int[n];
            int oddMin = 1;
            int evenMin = 2;
            int j = 0;
            int k = 0;
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (temp % 2 == 1) {
                    odd[j++] = temp;
                    oddMin = Math.max(temp, oddMin);
                } else {
                    even[k++] = temp;
                    evenMin = Math.max(evenMin, temp);
                }
            }
            Arrays.sort(odd);
            Arrays.sort(even);

            int oddLenMax = 0;
            int oddLenIndex = 1;
            for (int i = 0; i < n; i++) {
                if (i + 1 < n && odd[i + 1] != 0) {
                    oddLenMax = Math.max(oddLenMax, odd[i + 1] - odd[i]);
                    oddLenIndex = odd[i+1] + 2;
                } else {
                    break;
                }
            }
            if (oddLenMax < (99 - oddMin) / 2) {
                oddLenMax = (99 - oddMin) / 2;
                oddLenIndex = oddMin + 2;
            }

            int evenLenMax = 0;
            int evenLenIndex = 2;
            for (int i = 0; i < n; i++) {
                if (i + 1 < n && odd[i + 1] != 0) {
                    evenLenMax = Math.max(evenLenMax, even[i + 1] - even[i]);
                    evenLenIndex = even[i+1] + 2;
                } else {
                    break;
                }
            }
            if (evenLenMax < (100 - evenMin) / 2) {
                evenLenMax = (100 - evenMin) / 2;
                evenLenIndex = evenMin + 2;
            }

            if (oddLenMax > evenLenMax) {
                System.out.println(oddLenIndex + " " + oddLenMax);
            } else {
                System.out.println(evenLenIndex + " " + evenLenMax);
            }
        }
    }
}