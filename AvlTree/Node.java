package AvlTree;

public class Node {

    Node left;
    Node right;
    int data;
    int height;

    Node(int data) {
        this.data = data;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}
