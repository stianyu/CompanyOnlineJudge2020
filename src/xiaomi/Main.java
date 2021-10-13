package xiaomi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                String string = strs[i];
                char[] chs = string.toCharArray();
                int res = 0;
                if (chs.length < 8 || chs.length > 120) {
                    res = 1;
                } else {
                    boolean[] flag = new boolean[4];  // 数字，符号，大写字母，小写字母
                    for (int j = 0; j < chs.length; j++) {
                        if (Character.isDigit(chs[j])) {
                            flag[0] = true;
                        } else if (Character.isUpperCase(chs[j])) {
                            flag[2] = true;
                        } else if (Character.isLowerCase(chs[j])) {
                            flag[3] = true;
                        } else {
                            flag[1] = true;
                        }
                    }

                    for (int j = 0; j < 4; j++) {
                        if (!flag[j]) {
                            res = 2;
                        }
                    }
                }
                System.out.println(res);
            }
        }
    }
}
