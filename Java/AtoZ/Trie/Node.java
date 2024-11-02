package Java.AtoZ.Trie;

public class Node {
    public Node list[] = new Node[26];
    boolean flag = false;

    Node() {
    }

    boolean containsKey(char character) {
        return list[character - 'a'] != null;
    }

    void put(char ch, Node referenceNode) {
        list[ch - 'a'] = referenceNode;
    }

    Node getReferenceNode(char ch) {
        return list[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}
