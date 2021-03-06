package wangyish2;

import java.util.*;

public class Main2 {

    static int frontFd;
    static Map<Integer, String> map;
    static Set<Integer> set;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int T = Integer.parseInt(in.nextLine());

            List<String> res = new ArrayList<>();
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(in.nextLine());
                frontFd = 0;
                map = new HashMap<>();
                set = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    String[] strings = in.nextLine().split(" ");
                    if ("open".equals(strings[0])) {
                        int fd = open(strings[1]);
                        res.add(String.valueOf(fd));
                    } else if ("dup".equals(strings[0])) {
                        int fd = dup(Integer.parseInt(strings[1]));
                        res.add(String.valueOf(fd));
                    } else if ("dup2".equals(strings[0])) {
                        dup2(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
                    } else if ("close".equals(strings[0])) {
                        close(Integer.parseInt(strings[1]));
                    } else {
                        String fileName = query(Integer.parseInt(strings[1]));
                        res.add(fileName);
                    }
                }
            }

            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }

    public static int open(String fileName) {
        int temp = frontFd;
        map.put(temp, fileName);
        set.add(temp);
        while (set.contains(frontFd)) {
            frontFd++;
        }
        return temp;
    }

    public static int dup(int fd) {
        int temp = frontFd;
        map.put(temp, map.get(fd));
        set.add(temp);
        while (set.contains(frontFd)) {
            frontFd++;
        }
        return temp;
    }

    public static void dup2(int fd, int new_fd) {
        if (!set.contains(new_fd)) {
            set.add(new_fd);
        }
        map.put(new_fd, map.get(fd));
    }

    public static void close(int fd) {
        map.remove(fd);
        if (fd < frontFd) {
            frontFd = fd;
        }
        set.remove(fd);
    }

    public static String query(int fd) {
        return map.get(fd);
    }
}
/*
2
10
open libc.so    0
open libm.so    1
open libdl.so   2
dup 2           3
dup2 0 2
close 0
query 1         libm.so
query 2         libc.so
query 3         libdl.so
open log.txt    0
10
open output.txt  0
dup2 0 1000000
close 0
open output2.txt 0
dup2 0 100000
close 0
open 1.txt       0
dup 100000       1
query 1          output2.txt
query 0          1.txt

2
10
open libc.so
open libm.so
open libdl.so
dup 2
dup2 0 2
close 0
query 1
query 2
query 3
open log.txt
10
open output.txt
dup2 0 1
close 0
open output2.txt
dup2 0 1
close 0
open 1.txt
dup 100000
query 1
query 0

0
1
2
3
libm.so
libc.so
libdl.so
0
0
0
0
1
output2.txt
1.txt
 */