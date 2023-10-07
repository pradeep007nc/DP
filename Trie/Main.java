package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("mamamia");
        System.out.println(trie.search("mama"));
        System.out.println(trie.search("mamamia"));
    }
}
