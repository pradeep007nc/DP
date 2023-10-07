package Trie;

public class Trie {

    Node root;

    Trie(){
        root = new Node();
    }

    //time complexity O(n)
    public void insert(String word){
        Node node = root;
        for (int i=0;i<word.length();i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    //O(n)
    public boolean search(String word){
        Node node = root;
        for (int i=0;i<word.length();i++){
            if (!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startsWith(String word){
        Node node = root;
        for (int i=0;i<word.length();i++){
            if (!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }
}
