package Java.AtoZ.Tree;

import java.util.ArrayList;

public class AllPaths {
    static void traverse(TreeNode root, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> output) {

        if (root.left == null && root.right == null) {
            ds.add(root.val);
            output.add(new ArrayList<>(ds));
            return;
        }

        ds.add(root.val);
        if (root.left != null) {
            traverse(root.left, ds, output);
            ds.remove(ds.size() - 1);
        }

        if (root.right != null) {
            traverse(root.right, ds, output);
            ds.remove(ds.size() - 1);
        }
    }

    static ArrayList<ArrayList<Integer>> path(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        traverse(root, ds, output);

        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        // root.left.left = new TreeNode(40);
        // root.left.right = new TreeNode(60);

        root.right = new TreeNode(30);
        // root.right.left = new TreeNode(2);
        System.out.println(path(root));
    }
}
