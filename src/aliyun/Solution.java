package aliyun;

public class Solution {
    public int minFlips(String target) {
        int count = 0;
        int len = target.length();
        int[] num = new int[len];
        for(int i = 0; i < len; i++) {
            if((target.charAt(i) - '0') != (num[i] % 2)) {
                count++;
                for(int j = i; j < len; j++) {
                    num[j]++;
                }
            }
        }
        return count;
    }

    public int minFlip2(String target) {
        int count = 0;
        int len = target.length();
        int num = 0;
        for(int i = 0; i < len; i++) {
            int temp = num & 1<<(len-i-1);
            int temp2 = num - temp;
            if((target.charAt(i) - '0') == temp2 >> (len - i -1)) {
                count++;
                num = temp;
                num = ~num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String target = "10111";
        System.out.println(solution.minFlip2(target));
    }
}