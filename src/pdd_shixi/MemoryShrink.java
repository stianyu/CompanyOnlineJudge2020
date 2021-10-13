package pdd_shixi;

import java.util.Scanner;

/**
 * 拼多多服务端开发实习生机试-2020.06.02
 * 第二题：
 *      有 N 个内存块，一个内存块在压缩之前需要占用 Ai 的大小，压缩之后占用 Bi 的大小，其中 Bi <= Ai。
 *      现在对这 N 个内存块进行压缩，压缩内存块的顺序随意，计算压缩完这些内存块，所需要的最小空间是多少。
 *      输入：
 *          3
 *          7 1
 *          10 5
 *          20 10
 *      输出：
 *          21
 */
public class MemoryShrink {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//        	int n = Integer.parseInt(in.nextLine());
//            int[] ramUse = new int[n];
//            int[] save = new int[n];
//            for(int i = 0; i < n; i++) {
//            	String[] ramStr = in.nextLine().split(" ");
//            	ramUse[i] = Integer.parseInt(ramStr[1]);
//            	save[i] = Integer.parseInt(ramStr[0]) - ramUse[i];
//            }
//            int minSave = save[0];
//            int totalUse = 0;
//            for(int i = 0; i < n; i++) {
//            	if(save[i] < minSave) {
//            		minSave = save[i];  // 找压缩一次空间利用率最高的代码块，记录最后一次压缩所浪费的空间
//            	}
//            	totalUse += ramUse[i];  // 累加真正用的空间
//            }
//            System.out.println(totalUse + minSave);  // 返回就是 真正用的空间 + 最后一次压缩所浪费的空间
//        }
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            int[] spaceNeed = new int[n];
            int[] spaceUsed = new int[n];
            int[] save = new int[n];
            for(int i = 0; i < n; i++) {
                String[] ramStr = in.nextLine().split(" ");
                spaceNeed[i] = Integer.parseInt(ramStr[0]);
                spaceUsed[i] = Integer.parseInt(ramStr[1]);
                save[i] = spaceNeed[i] - spaceUsed[i];
            }
            int minSave = save[0];
            int totalUse = 0;
            for(int i = 0; i < n; i++) {
                if(save[i] < minSave) {
                    minSave = save[i];  // 找压缩一次空间利用率最高的代码块，记录最后一次压缩所浪费的空间
                }
                totalUse += spaceUsed[i];  // 累加真正用的空间
            }
            System.out.println(totalUse + minSave);  // 返回就是 真正用的空间 + 最后一次压缩所浪费的空间
        }
    }

}
