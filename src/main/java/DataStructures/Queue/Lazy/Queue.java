/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:41
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.Lazy;

import DataStructures.LinkedList.LinkedList;

public class Queue {
    private LinkedList linkedList;

    public Queue(){
        this.linkedList = new LinkedList();
    }

    /**
     * adds an element to the queue*/
    public void enqueue(int element){
        linkedList.insertEnd(element);
    }
    public int dequeue() throws Exception {
        return linkedList.removeHead();
    }
}
