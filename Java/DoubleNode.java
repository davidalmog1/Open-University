package OpenUTesting;

public class DoubleNode {
/** ========== Variables ==========**/
    private int date;
    private DoubleNode next;
    private DoubleNode previous;

/** ========== constructor ==========**/
    public DoubleNode(int data){
        this.date =data;
    }

/** ========== Getters & Setters ==========**/
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

}//end class
