package AvlTree;

public class main {
    public static void main(String[] args) {
        int[] arr = { 30, 25, 35, 20, 15, 5, 10, 50, 60, 70, 65 };
        Tree tree2 = new Tree();
        for (int i : arr) {
            tree2.insert(i);
        }
        tree2.inOrder(tree2.root);
    }

}
