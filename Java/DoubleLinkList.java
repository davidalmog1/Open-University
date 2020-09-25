package OpenUTesting;

public class DoubleLinkList {
/** ========== Variables ==========**/
private DoubleNode head;
private DoubleNode tail;
int size;

/** ========== Constructor ==========**/

/** ========== Getters & Setters ==========**/
public DoubleNode getHead() {
    return head;
}

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

/** ========== Methods ==========**/
public void addToStart(int data){
    DoubleNode node = new DoubleNode(data);
    node.setNext(head);
    if(head == null){
        tail = node;
    }else {
        head.setPrevious(node);
    }
    head = node;
    size++;
}

    public  void addToEnd(int data){
    DoubleNode node = new DoubleNode(data);
    if(head == null){
        head = node;
    }else{
     node.setPrevious(tail);
     tail.setNext(node);
    }
    tail = node;
    size++;
}

    public boolean isEmpty(){
        if(head == null)
            return true;
        else
            return false;
    }

    public void printList(){
    if( isEmpty() ){
        System.out.println("\nThe List Empty\n");
    }
    DoubleNode temp = head;
        System.out.print("\nHead -> ");
        while(temp != null){
            System.out.print(temp.getDate());
            System.out.print(" <=> ");
            temp = temp.getNext();
        }
        System.out.print("null\n");
    }

    public int countAllValues(){
        DoubleNode temp = head;
        return countAllValues(temp,0);
    }
    private int countAllValues(DoubleNode temp, int val) {
        if(temp == null){
            return val;
        }
        return countAllValues(temp.getNext(),val = val +temp.getDate());
    }

}//end class
