package vivo;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] strings = string.substring(1, string.length()-1).split(",");
            int len = strings.length;

            int[] nums = new int[len];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(strings[i]);
                map.put(i, nums[i]);
            }

        }
    }
}
/*
def rrr(a):
    c={}
    for i in range(len(a)):
        c[a[i]] = c.get(a[i], []) + [i]
    d=c[-1]
    e=[]
    while len(d)>0:
        e.append(d[0])
        if d[0] in c.keys():
            d=d+c[d[0]]
        d.remove(d[0])
    return e

a=input().split()
print(rrr(a))
 */