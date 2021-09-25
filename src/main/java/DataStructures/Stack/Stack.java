/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:39
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Stack;

import DataStructures.LinkedList.LinkedList;

public class Stack {
    private LinkedList stack;

    public Stack(){
        this.stack = new LinkedList();
    }

    public int push(int value){
        this.stack.insertHead(value);
        return value;
    }

    public int pop(){
        return this.stack.removeHead();
    }
}
