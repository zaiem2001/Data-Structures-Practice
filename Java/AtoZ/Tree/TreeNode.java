package Java.AtoZ.Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(this, sb);
        return sb.toString();
    }

    // Helper method for in-order traversal (left-root-right)
    private void inOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        // Traverse the left subtree
        // Append the root node's value
        sb.append(node.val).append(" ");
        inOrderTraversal(node.left, sb);
        // Traverse the right subtree
        inOrderTraversal(node.right, sb);
    }

}
