package Java.AtoZ.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class Vertical {
    static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int col = t.col;
            TreeNode node = t.node;

            if (!map.containsKey(col))
                map.put(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(new Tuple(node.left, col - 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, col + 1));
            }
        }

        List<List<Integer>> output = new ArrayList<>();

        // System.out.println(map);
        for (List<Integer> l : map.values()) {
            l.sort(null);
            output.add(l);
        }

        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        // root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }
}

class Tuple {
    int col;
    TreeNode node;

    Tuple(TreeNode _node, int _col) {
        this.col = _col;
        this.node = _node;
    }
}
