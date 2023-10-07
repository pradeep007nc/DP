package Trie;

public class Node {
    Node links[];
    boolean flag;

    Node(){
        this.links = new Node[26];
        this.flag = false;
    }

    public boolean containsKey(char ch){
        return (this.links[ch - 'a'] != null);
    }

    public void put(char ch, Node node){
        this.links[ch - 'a'] = node;
    }

    public Node get(char ch){
        return this.links[ch - 'a'];
    }

    public void setEnd(){
        this.flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}
