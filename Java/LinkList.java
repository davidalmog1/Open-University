//package OpenUTesting;
//
//public class LinkList {
//    //variables
//    private Node head;
//
//    /**
//     *
//     * Adding Node to List
//     */
//    public void addFromHead(int data){
//        Node newNode = new Node(data);
//        newNode.setNext(head);
//        head =newNode;
//    }
//    /**
//     * Adding Node to End of the List Using Recursion
//     */
//    public void addNodeToEndOfListUsingRecursion(int data){
//        if (isEmpty(head)) {
//            Node newNode = new Node(data);
//            setHead(newNode);
//            return;
//        }
//        Node temp = head;
//        head.setNext(addNodeToEndOfListUsingRecursion(temp,data));
//    }
//    private Node addNodeToEndOfListUsingRecursion(Node temp,int data){
//        if(temp.getNext() == null){
//            Node newNode = new Node(data);
//            temp.setNext(newNode);
//            return temp;
//        }
//        temp = temp.getNext();
//        return addNodeToEndOfListUsingRecursion(temp,data);
//    }
//
//    /**
//     * Print all the LinkList
//     */
//    public void printList(){
//        Node temp = head;
//        if(isEmpty(temp)) {
//            System.out.println("The list is Empty");
//            return;
//        }
//        while(temp != null){
//            System.out.print(temp.getData()+" -> ");
//            temp =temp.getNext();
//        }
//    }
//
//    /**
//     *
//     * Printing all using recursion
//     */
//    public void PrintListUsingRecursion(){
//        Node temp = head;
//        if (isEmpty(temp))
//            return;
//        PrintListUsingRecursion(temp);
//    }
//    private void PrintListUsingRecursion(Node temp){
//        if(temp.getNext() == null) {
//            System.out.print(temp.getData());
//            return;
//        }
//        System.out.print(temp.getData()+" -> ");
//        PrintListUsingRecursion(temp.getNext());
//    }
//
//    public boolean isEmpty(Node node){
//        if(node == null)
//            return true;
//        else
//            return false;
//    }
//
//    public boolean isSubset (LinkList other){
//        Node tailThis = sortList(head);
//        Node tailOther = sortList(other.head);
//        while(tailOther != null){
//            if(tailThis.getData())
//        }
//    }
//    public Node sortList(Node temp){
//        while(temp.getNext() != null){
//            int nextData = temp.getNext().getData();
//            if(temp.getData() > nextData){
//                int thisData = temp.getData();
//                temp.setData(nextData);
//                temp.getNext().setData(thisData);
//            }
//            temp = temp.getNext();
//        }
//        if(temp.getNext().getData() > temp.getData()){
//            int thisData = temp.getData();
//            temp.setData(temp.getNext().getData());
//            temp.getNext().setData(thisData);
//        }
//        return temp.getNext(); //return tail
//    }
//
//
//    public Node switchPlaces(Node a){
//        int temp = a.getData();
//        a.setData(a.getNext().getData());
//        a.getNext().setData(temp);
//        return a;
//    }
//
//    //getters & setters
//    public Node getHead() {
//        return head;
//    }
//    public void setHead(Node head) {
//        this.head = head;
//    }
//
//
//}//end class
