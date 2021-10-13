package bigo2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
    
    static class Node{
        
        private int row;
        private int col;
        private int val;

        private Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static int[] merge(int[][] nums, int n, int k) {

        Queue<Node> priorityQueue = new PriorityQueue<Node>(
                k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < nums.length; i++) {
            if(nums[i].length > 0) {
                Node e = new Node(i, 0, nums[i][0]);
                priorityQueue.add(e);
            }
        }

        int[] res = new int[n];
        int count = 0;
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            res[count++] = node.val;
            if(node.col + 1 < nums[node.row].length) {
                priorityQueue.add(new Node(node.row, node.col+1, nums[node.row][node.col+1]));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7},{2, 4, 6},{0, 8, 9, 10, 11}};
        int[] res = merge(nums, 10, 3);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
/*
 Input: 
  [
    [1, 3, 5, 7],
    [2, 4, 6],
    [0, 8, 9, 10, 11]
  ]
  
Output: 
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */