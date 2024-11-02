package Java.AtoZ.Trie;

public class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.getReferenceNode(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch))
                return false;

            node = node.getReferenceNode(ch);
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch))
                return false;
            node = node.getReferenceNode(ch);
        }

        return true;
    }
}
