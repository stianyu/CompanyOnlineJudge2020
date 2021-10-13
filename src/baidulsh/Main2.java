package baidulsh;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strings = in.nextLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int orderN = Integer.parseInt(strings[1]);
            HashMap<Integer, Deque<Integer>> map = new HashMap<>();
            HashMap<Integer, Integer> peoplePos = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                Deque<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                map.put(i, queue);
                peoplePos.put(i, i);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < orderN; i++) {
                String[] msg = in.nextLine().split(" ");
                if ("C".equals(msg[0])) {
                    int closeN = Integer.parseInt(msg[1]);
                    int openN = Integer.parseInt(msg[2]);
                    Deque<Integer> closeDeque = map.get(closeN);
                    Deque<Integer> openDeque = map.get(openN);
                    while (!closeDeque.isEmpty()) {
                        int people = closeDeque.poll();
                        peoplePos.put(people, openN);
                        openDeque.add(people);
                    }
                } else {
                    int people1 = Integer.parseInt(msg[1]);
                    int people2 = Integer.parseInt(msg[2]);
                    int people1Pos = peoplePos.get(people1);
                    int people2Pos = peoplePos.get(people2);
                    if (people1Pos != people2Pos) {
                        res.add(-1);
                    } else {
                        Deque<Integer> deque = map.get(people1Pos);
                        Iterator<Integer> iterator = deque.iterator();
                        boolean flag = false;
                        int count = 0;
                        while (iterator.hasNext()) {
                            int temp = iterator.next();
                            if (temp == people1 || temp == people2) {
                                flag = !flag;
                            }
                            if (flag) {
                                count++;
                            }
                        }
                        res.add(count - 1);
                    }
                }
            }
            for (int value : res) {
                System.out.println(value);
            }
        }
    }
}
/*
6 6
C 3 6
C 4 1
Q 1 6
C 1 6
Q 1 6
Q 2 5
 */