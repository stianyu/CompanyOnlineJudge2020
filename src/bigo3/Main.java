package bigo3;

public class Main {
    public static void main(String[] args) {
        String a="4563";
        String b="7547";
        int t = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || t > 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sum += t;
            sb.append(sum % 10);
            t = sum / 10;
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
