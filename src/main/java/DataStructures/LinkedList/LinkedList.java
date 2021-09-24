/**
 * @author giuliano ranauro
 * Date: 20/09/2021 23:17
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.LinkedList;

public class LinkedList {
    private Node head;      //the first node


    public LinkedList(){}

    public void insert(int valueToInsert){
        Node newNode = new Node(valueToInsert);

        if (this.head == null){
            this.head = newNode;
            return;
        }

        Node current = this.head;


        while (current.getNext() != null){
            current = current.next;
        }
        current.next = newNode;
    }
    
    public int removeHead(){
        int headValue = this.head.getValue();
        this.head = head.getNext();
        
        return headValue;
    }

    public void printList(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }


    private class Node{
        private int value;      // the node value
        private Node next;      // the next node

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
