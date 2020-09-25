package OpenUTesting;

import com.sun.source.tree.NewClassTree;

import java.util.EmptyStackException;
import java.util.prefs.NodeChangeEvent;

/**
 * Name: david
 * Data: 2020
 * Abstract Data Type
 * LIFO - Last in,First Out
 * Operations:
 *     1. push - adds an item as the top item in the stack
 *     2. pop - removes the top item on the stack
 *     3. peek - see the top item on the stack (value)
 *
 */
public class Stack {
    //variables
    private Node top;

    //getters & setters
    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    //methods
    public boolean isEmpty(){
        return top == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {
            setTop(newNode);
        }else{
            newNode.setNext(top);
            setTop(newNode);
        }
    }

    public Node pop(){
        if(isEmpty()) {
            System.out.println("\nThe Stack is Empty");
            return null;
        }else{
            Node nodeToPop = top;
            setTop(top.getNext());
            return nodeToPop;
        }
    }

    public int peek() throws EmptyStackException {
          if(isEmpty()){
              System.out.println("\nThe Stack is Empty");
              throw new EmptyStackException();
          }
          else{
              return top.getData();
          }
    }

}//end main
