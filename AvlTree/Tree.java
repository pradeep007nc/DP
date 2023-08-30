package AvlTree;

public class Tree {

    Node root = null;

    public int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // rotate right
    private Node rotateRight(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotate left
    private Node rotateLeft(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // insert node
    // helper method within the class
    private Node insertNode(Node node, int val) {
        if (node == null) {
            Node newNode = new Node(val);
            newNode.height = 1;
            return newNode;
        } else if (val < node.data) {
            node.left = insertNode(node.left, val);
        } else {
            node.right = insertNode(node.right, val);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // left left condition i.e right rotation
        if (balance > 1 && val < node.left.data) {
            return rotateRight(node);
        }
        // left right condition
        if (balance > 1 && val > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // right right condition i.e left rotation
        if (balance < -1 && val > node.right.data) {
            return rotateLeft(node);
        }
        // right left condition
        if (balance < -1 && val < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    // public insert method to access outside of class
    public void insert(int value) {
        root = insertNode(root, value);
    }

    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data +" height is :"+ root.height);
        inOrder(root.right);
    }

}
