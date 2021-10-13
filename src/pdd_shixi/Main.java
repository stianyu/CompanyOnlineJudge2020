package pdd_shixi;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            for(int i = 0; i < num; i++) {
            	String s = in.nextLine();
            	String[] str = s.split(" ");
            	int n = Integer.parseInt(str[0]);
            	int k = Integer.parseInt(str[1]);
            	int res =  k / (n - 1) * n + k % (n - 1);
            	if(k % (n - 1) == 0) {
            		res = res - 1;
            	}
            	System.out.println(res);
            }
        }
    }
}
