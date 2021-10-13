package baidulsh;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int t = in.nextInt();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int m = in.nextInt();
                int n = in.nextInt();
                Map<Integer, Integer> person = new TreeMap<>();
                Map<Integer, Integer> role = new TreeMap<>();
                for (int j = 0; j < n; j++) {
                    person.put(in.nextInt(), i);
                }
                for (int j = 0; j < m; j++) {
                    role.put(in.nextInt(), i);
                }
                int index1 = 0, index2 = 0;
                while (index1 < n) {
                    if (index2 < m) {
                        if (person.get(index1) <= role.get(index2)) {
                            res.set(person.get(index1++), role.get(index2) + 1);
                        }
                        index2++;
                    }
                    else {
                        res.set(person.get(index1++), -1);
                    }
                }
            }
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

}

/*
2
3 6
33 66 99
3 6 9 30 60 90
3 6
33 66 99
66 66 66 66 66 66
* */