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

    public boolean hasNext(){
        return this.head!=null;
    }

    public void insertEnd(int valueToInsert){
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

    public void insertHead(int valueToInsert){
        Node newNode = new Node(valueToInsert);
        newNode.setNext(this.head);

        if (this.head == null){
            this.head = newNode;
            return;
        }

        Node oldHead = this.head;
        this.head = newNode;
    }

    public int removeHead(){
        int headValue = this.head.getValue();
        this.head = head.getNext();

        return headValue;
    }

    public int removeEnd() throws Exception{
        Node current = this.head;

        while (current.next != null) {
            if (current.getNext() == null) {
                int removed = current.getNext().getValue();
                current.setNext(null);
                return removed;
            }
            current = current.getNext();
        }

        throw new Exception("cannot remove last element");
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
