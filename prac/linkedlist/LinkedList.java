package prac.linkedlist;

public class LinkedList {

    Node head;

    LinkedList(int n){
        this.head = new Node(n);
    }


    public void insert(int n){
        Node temp = head;
        while (temp.right != null){
            temp = temp.right;
        }
        temp.right = new Node(n);
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.n+"  ");
            temp = temp.right;
        }
        System.out.println();
    }

    public void reverse(Node head){
        if (head == null || head.right == null)
        {
            this.head = head;
            return;
        }
        reverse(head.right);
        head.right.right = head;
        head.right = null;
    }

}
