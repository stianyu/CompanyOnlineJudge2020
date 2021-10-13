package huawei2;

public class Main2 {
    public static void main(String[] args) {
        String str1 = "babad";
        String str2 = "bab";
        System.out.println(helper(str1));
    }

    private static String helper(String string) {
        int len = string.length();
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int end = begin;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (string.charAt(l) != string.charAt(r)) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = false;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
                if (dp[l][r] && r - l + 1 > maxLen) {
                    begin = l;
                    end = r;
                    maxLen = end - begin + 1;
                }
            }
        }

        return string.substring(begin, end);
    }
}
