package OpenUTesting;

/**
 * this Node is for LinkList
 */
public class Node {
    //variables
    private int data;
    private Node next;

    //constructor
    public Node(int data, Node next) {
        this.data=data;
        this.next = next;
    }
    public Node(int data){
        this.data=data;
        this.next=null;
    }

    //getters & setters
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

}
