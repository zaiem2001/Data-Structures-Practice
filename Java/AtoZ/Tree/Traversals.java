package Java.AtoZ.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversals {
    static void preorder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        List<Integer> output = new ArrayList<>();
        s.add(root);

        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            output.add(currentNode.val);

            if (currentNode.right != null)
                s.add(currentNode.right);

            if (currentNode.left != null) {
                s.add(currentNode.left);
            }
        }

        System.out.println(output);
    }

    static void postorder(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        List<Integer> output = new ArrayList<>();
        s.add(root);

        while (!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            output.add(currentNode.val);

            if (currentNode.left != null)
                s.add(currentNode.left);
            if (currentNode.right != null)
                s.add(currentNode.right);
        }

        System.out.println(output.reversed());
    }

    // BFS
    static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> wrapper = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode currentNode = queue.peek();
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

                wrapper.add(queue.poll().val);
            }
            output.add(wrapper);
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);

        // System.out.println(root);
        preorder(root);
        postorder(root);
        levelOrder(root);
    }
}
