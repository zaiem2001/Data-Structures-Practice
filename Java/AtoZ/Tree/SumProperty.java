package Java.AtoZ.Tree;

public class SumProperty {
    static int isSumProperty(TreeNode root) {
        if (root == null)
            return 1;

        if (root.left == null && root.right == null)
            return 1;

        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        if (root.val == leftVal + rightVal) {
            int leftCheck = isSumProperty(root.left);
            int rightCheck = isSumProperty(root.right);

            if (leftCheck == 1 && rightCheck == 1) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(6);
        // root.right.left = new TreeNode(13);
        // root.right.right = new TreeNode(2);

        System.out.println(isSumProperty(root));
    }
}
