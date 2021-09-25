/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:38
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.ArrayStack;

public class Stack {
    private int size;
    private int control;

    private Integer[] array;

    public Stack(int size){
        this.size = size;
        this.array = new Integer[size];

        this.control = -1;		//usato per controllare se c'è un overflow
    }

    public void push(int item){
        if (control + 1 > size) {
            System.err.println("Stack overflow.\nCannot push element, the array is full.");
        }else {
            control += 1;
            array[control] = item;
        }
    }

    public int pop() throws Exception{
        if (this.control <0) {
            throw new Exception("Stack underflow.");
        }
        int top = this.array[control];

        this.array[control] = null;

        return top;
    }



    public Integer[] getArray(){
        return this.array;
    }
}
