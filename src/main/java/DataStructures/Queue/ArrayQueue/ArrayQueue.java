/**
 * @author giuliano ranauro
 * Date: 25/09/2021 17:00
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.ArrayQueue;

/**
 * abbiamo due puntatori, che ci permettono di definire quali sono il front e back della queue
 * quando devo aggiungere un nuovo elemento, aggiungo a tail (q[tail]) e quando devo rimuovere rimuovo da head (q[head])
 * ad ogni operazione aggiorno i contatori. Anche in questo caso avrei bisogno del resize array*/
public class ArrayQueue {
    private String[] array;
    private int first,last,size;

    public ArrayQueue(int size){
        this.array = new String[size];
        this.size = size;
        this.first = -1;
        this.last = -1;
    }

    public boolean isEmpty(){
        /** @Todo */
        return true;
    }

    public void enqueue(String element){
        if (this.first == -1){
            first+=1;
            last+=1;
            this.array[first] = element;
        }else {
            if (this.last+1 > size){
                System.err.println("Array Overflow.");
            }else {
                this.last+=1;
                this.array[last] = element;
            }
        }
    }

    public String dequeue(){
        if (first < 0 && last < 0 )
            System.err.println("Array underflow");
        String delete = this.array[first];
        first++;


        return delete;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
