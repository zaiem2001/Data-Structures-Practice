package Java.AtoZ.Trie;

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        // System.out.println(trie.search("a"));
    }
}
