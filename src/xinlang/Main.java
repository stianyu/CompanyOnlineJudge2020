package xinlang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] strings = in.nextLine().split(",");

            int n = strings.length;
            TreeNode root = generateTreeNode(strings);
            String res = printTreeNode(dfs(root));
            System.out.println(res.substring(0, res.length() - 1));
        }
    }

    private static String printTreeNode(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            res += String.valueOf(node.value) + ",";
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    private static TreeNode dfs(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode res = dfs(root.left);
        root.left = null;
        root.right = null;
        left.right = root;
        left.left = right;
        return res;
    }

    private static TreeNode generateTreeNode(String[] strings) {
        int n = strings.length;
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index == n) {
                break;
            }
            node.left = new TreeNode(Integer.parseInt(strings[index++]));
            queue.add(node.left);
            if (index == n) {
                break;
            }
            node.right = new TreeNode(Integer.parseInt(strings[index++]));
            queue.add(node.right);
        }
        return root;
    }
}

class TreeNode{

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}
