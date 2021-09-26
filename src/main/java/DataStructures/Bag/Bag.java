/**
 * @author giuliano ranauro
 * Date: 26/09/2021 20:18
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Bag;

import DataStructures.Queue.Optimized.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag implements Iterable<String>{
    private Node first;

    private int size;

    public Bag(){
        this.first = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.first==null;
    }

    public void add(String item){
        Node node = new Node();
        node.setValue(item);
        if (first == null){
            this.first = node;
        }else{
            Node oldFirst = this.first;
            this.first = node;
            this.first.setNext(oldFirst);
        }
        this.size++;
    }

    public void remove(){}




    @Override
    public Iterator<String> iterator() {
        return  null;
    }

    private class CustomIterator implements Iterator<String>{
        Node current;

        CustomIterator(Node current){
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public String next() {
            if (this.hasNext()){
                this.current = current.getNext();
                return current.getNext().getValue();
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            // empty method
        }
    }
}
