package prac.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(5);
        int[] arr = {1,2,3,4,5,6};
        for (int i:arr){
            list.insert(i);
        }

        list.display();
        list.reverse(list.head);
        list.display();
    }

}
