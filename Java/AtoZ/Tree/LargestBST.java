package Java.AtoZ.Tree;

public class LargestBST {

    // postorder
    static Info find(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = find(root.left);
        Info rightInfo = find(root.right);

        // calculations
        if (root.val > leftInfo.max && root.val < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            return new Info(Math.min(root.val, leftInfo.min), Math.max(root.val, rightInfo.max), size);
        }

        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftInfo.size, rightInfo.size));
    }

    static int largest(TreeNode root) {
        Info info = find(root);
        return info.size;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(6);
        // root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        // root.right.right.right = new TreeNode(4);
        // root.right.right.right.right = new TreeNode(14);

        System.out.println(root);
        System.out.println(largest(root));
    }
}

class Info {
    public int max, min, size;

    Info(int min, int max, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}