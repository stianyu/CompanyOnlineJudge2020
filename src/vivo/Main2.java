package vivo;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String string = in.nextLine();
            char[] chs = string.toCharArray();
            int l = 0, r = chs.length - 1;
            int delIndex = -1;
            while (l < r) {
                if (chs[l] == chs[r]) {
                    l++;
                    r--;
                } else {
                    if (help(chs, l + 1, r)) { // 如果删左边就能找到回文串，直接删除l
                        delIndex = l;
                    } else if (help(chs, l, r - 1)) { // 删左边不能找对回文串，才考虑删右边
                        delIndex = r;
                    }
                    break;
                }
            }
            if (help(chs, l, r)) {
                System.out.println(string);
            } else if (delIndex != -1) {
                System.out.println(string.substring(0, delIndex) + string.substring(delIndex+1));
            } else {
                System.out.println(false);
            }
        }
    }

    private static boolean help(char[] chs, int l, int r) {
        while (l < r) {
            if (chs[l] == chs[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
