package Java.AtoZ.Tree;

import java.util.HashMap;
import java.util.Map;

public class Construct {
    static void buildInorder(Map<Integer, Integer> map, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }

    static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderIdx = map.get(root.val);
        int leftElems = inorderIdx - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftElems, inorder, inStart, inorderIdx - 1, map);
        root.right = build(preorder, preStart + leftElems + 1, preEnd, inorder, inorderIdx + 1, inEnd, map);

        return root;
    }

    static TreeNode preIn(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        buildInorder(map, inorder);
        return build(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = preIn(preorder, inorder);
        System.out.println(root);
    }
}
