package genshuixue;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        Map<String, Node> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String emails = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                if (!map.containsKey(account.get(i))) {
                    map.put(account.get(i), new Node());
                    map.get(account.get(i)).parent = map.get(account.get(i));
                    map.get(account.get(i)).name = name;
                    map.get(account.get(i)).email = account.get(i);
                }
                union(map.get(emails), map.get(account.get(i)));
            }
        }

        Map<String, Set<String>> res = new HashMap<>();
        for (Map.Entry<String, Node> e : map.entrySet()) {
            Node key = find(map.get(e.getKey()));
            res.putIfAbsent(key.email, new TreeSet<>());
            res.get(key.email).add(e.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (Set<String> set : res.values()) {
            List<String> temp = new ArrayList<>(set);
            temp.add(0, map.get(temp.get(0)).name);
            result.add(temp);
        }

        return result;
    }

    public static void union(Node x, Node y) {
        Node a = find(x);
        Node b = find(y);
        a.parent = b;
    }

    public static Node find(Node x) {
        if (x != x.parent) {
            x.parent = find(x.parent);
        }
        return x.parent;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _count = Integer.parseInt(in.nextLine());

        int _i = 0;
        List<List<String>> _accounts = new ArrayList<List<String>>();
        while (_i++ < _count) {
            String _line = in.nextLine();
            String[] _item = _line.split(",");
            _accounts.add(Arrays.asList(_item));
        }

        List<List<String>> res = mergeAccount(_accounts);

        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                String aName1 = String.join(",", o1);
                String aName2 = String.join(",", o2);
                return aName1.compareTo(aName2);
            }

        });

        for (int res_i = 0; res_i < res.size(); res_i++) {
            List<String> resItem = res.get(res_i);
            System.out.println(String.join(",", resItem));
        }
    }
}

class Node{
    Node parent;
    String name;
    String email;
}