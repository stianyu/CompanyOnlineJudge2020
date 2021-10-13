package bigo;

public class CheckDomainTest {
    public static void main(String[] args) {
        String str = "&";               // code -1
        String str2 = "www.bigo.arg";   // code 0
        String str3 = ".www.bigo.arg";  // code 1
        String str4 = "www.bigo.arg.";  // code 1
        String str5 = "abcdefghigklmnopqrstuvwxyzabcdefghigklmnopqrstuvwxyz.bigo.arg";   // code 2
        String str6 = "www-.bigo.arg";  // code 3
        String str7 = "www..bigo.arg";  // code 3
        String str8 = "www--bigo.arg";  // code 0
        String str9 = "www-bigo-arg";   // code 4

        System.out.println(checkDomain(str));
        System.out.println(checkDomain(str2));
        System.out.println(checkDomain(str3));
        System.out.println(checkDomain(str4));
        System.out.println(checkDomain(str5));
        System.out.println(checkDomain(str6));
        System.out.println(checkDomain(str7));
        System.out.println(checkDomain(str8));
        System.out.println(checkDomain(str9));
    }

    /**
     * 验证合法的域名
     * 错误代码code:   -2 : 输入的域名超过255字节
     *                -1 : 输入的域名有非法字符（除字母、数字、连接符、分隔符）
     *                 0 : 输入合法
     *                 1 : 输入的域名首字符、尾字符为连接符或分隔符
     *                 2 : 输入的域名标签超过63字节
     *                 3 : 输入的域名中分隔符前有连接符或分隔符、输入的域名中标签的起始字符为连接符或分隔符
     *                 4 : 输入的域名没有一个分隔符
     *
     * @param str 输入一个域名
     * @return code 输出错误码
     */
    private static int checkDomain(String str) {
        int code = 0;  // 错误代码
        char[] chars = str.toCharArray();
        if (chars.length > 127 || chars.length == 0) {
            return -2;
        }

        int labelCount = 0;   // 标签计数
        boolean lastCharIsLink = false;  // 上一个字符是否是连接符
        boolean lastCharIsSplit = false;  // 上一个字符是否是分割符
        boolean withoutLink = true;

        for (int i = 0; i < chars.length; i++) {
            // 如果整个字符串的任何一个字符不是字母、数字、连接符、分隔符，则输出非法代码-1
            if (isWhat(chars[i]) > 0) {
                // 1. 考虑头和尾的场景：如果整个字符串的第一个起始字符或最后一个字符为分隔符和连接符，则输出非法代码1
                if (i == 0 || i == chars.length - 1) {
                    if (isWhat(chars[i]) > 1) {
                        code = 1;
                        break;
                    } else {
                        labelCount++;
                        continue;
                    }
                } else {  // 2. 考虑中间的字符的场景
                    // 如果当前标签计数超过31（超过64字节），则输出非法代码2
                    if (labelCount > 31) {
                        code = 2;
                        break;
                    }
                    // 如果当前字符为分隔符
                    if (isWhat(chars[i]) == 2) {
                        // 如果当前字符为分隔符，且上一个字符为连接符或分隔符，则输出错误代码3
                        if(lastCharIsLink || lastCharIsSplit) {
                            code = 3;
                            break;
                        } else { // 如果当前字符为分隔符，且上一个字符不为连接符，则把标签计数归0，继续遍历
                            labelCount = 0;
                            lastCharIsSplit = true;
                            withoutLink = false;
                            continue;
                        }
                    }
                    // 如果当前字符为连接符，则把连接符的标志位设为true
                    if (isWhat(chars[i]) == 3) {
                        // 如果当前字符为连接符，且上一个字符为分隔符，则输出错误代码3
                        if (lastCharIsSplit) {
                            code = 3;
                            break;
                        } else {  // 如果当前字符为连接符，且上一个字符不为分隔符，则更新当前字符是连接符标志位
                            lastCharIsLink = true;
                            continue;
                        }
                    }
                    // 如果当前字符为字母或数字，则标签计数+1，且设置上一个字符不是连接符也不是分隔符
                    if (isWhat(chars[i]) == 1) {
                        labelCount++;
                        lastCharIsLink = false;
                        lastCharIsSplit = false;
                        continue;
                    }
                }
            } else {
                code = -1;
                break;
            }
        }

        // 遍历到最后没有一个分隔符
        if (code == 0 && withoutLink) {
            code = 4;
        }

        return code;
    }

    public static int isWhat(char c) {
        if (Character.isDigit(c) || Character.isAlphabetic(c)) {
            return 1;
        }
        if (c == '.') {
            return 2;
        }
        if (c == '-') {
            return 3;
        }
        return -1;
    }
}
