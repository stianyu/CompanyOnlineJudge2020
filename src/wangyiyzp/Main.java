package wangyiyzp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            char[] chs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            char lastC = chs[0];
            int count = 1;
            for (int i = 1; i < chs.length; i++) {
                while (i < chs.length && chs[i] == lastC) {
                    i++;
                    count++;
                }
                if (count < 4) {
                    for (int j = 0; j < count; j++) {
                        sb.append(lastC);
                    }
                } else {
                    int n = count / 55;
                    int m = count % 55;
                    // 超过55的部分，分段
                    for (int j = 0; j < n; j++) {  // 0Z段重复n次拼接
                        sb.append("0Z");
                        sb.append(lastC);
                    }
                    sb.append(0);   // 非0Z段直接拼上
                    char c;
                    if (m <= 29 ) {
                        c = (char) ('a' + m - 4);
                    } else {
                        c = (char) ('A' + m - 30);
                    }
                    sb.append(c);
                    sb.append(lastC);
                }
                if (i >= chs.length) {
                    break;
                } else if (i == chs.length - 1) {
                    sb.append(chs[i]);
                    break;
                } else {
                    count = 1;
                    lastC = chs[i];
                }
            }
            System.out.println(sb.toString());
        }
    }
}
/*
abbbbbbAAAdcdddd
BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeFYHHnjHAPQQcc
 */