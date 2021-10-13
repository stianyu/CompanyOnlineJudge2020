package xinlang;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String string = in.nextLine();
            char[] chs = string.toCharArray();

            boolean[] flag = new boolean[256];
            boolean res = true;
            for (int i = 0; i < chs.length; i++) {
                if (flag[chs[i]]) {
                    res = false;
                    break;
                }
                flag[chs[i]] = true;
            }
            System.out.println(res);
        }
    }
}
