package tx;

import java.util.*;

public class Main2 {
    static HashMap<Integer, List<Integer>> peopleInGroup;
    static List<int[]> groups;
    static HashSet<Integer> res;
    static boolean[] vistied;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            groups = new ArrayList<>();
            HashSet<Integer> hasZero = new HashSet<>();
            peopleInGroup = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = in.nextInt();
                int[] nums = new int[num];
                for (int j = 0; j < num; j++) {
                    nums[j] = in.nextInt();
                    List<Integer> tempList = peopleInGroup.get(nums[j]);
                    if (tempList == null) {
                        tempList = new ArrayList<>();
                    }
                    tempList.add(i);
                    peopleInGroup.put(nums[j], tempList);
                    if (nums[j] == 0) {
                        hasZero.add(i);
                    }
                }
                groups.add(nums);
            }
            vistied = new boolean[m];
            res = new HashSet<>();
            if (hasZero.size() != 0) {
                res.add(0);
            }
            for (int groupNum : hasZero) {
                int[] group = groups.get(groupNum);
                vistied[groupNum] = true;
                for (int i = 0; i < group.length; i++) {
                    if (res.add(group[i])) {
                        helper(group[i]);
                    }
                }
            }
            System.out.println(res.size());
        }
    }

    private static void helper(int index) {
        List<Integer> groupIndexList = peopleInGroup.get(index);
        for (int i = 0; i < groupIndexList.size(); i++) {
            int groupIndex = groupIndexList.get(i);
            if (!vistied[groupIndex]) {
                vistied[groupIndex] = true;
                int[] group = groups.get(groupIndex);
                for (int j = 0; j < group.length; j++) {
                    if (res.add(group[j])) {
                        helper(group[j]);
                    }
                }
            }
        }
    }
}
/*
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2
 */