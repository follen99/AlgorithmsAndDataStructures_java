/**
 * @author giuliano ranauro
 * Date: 18/10/2021 09:32
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package UsefulCode;

public class MinHeap {
    private int[] theHeap;
    private int capacity;
    private int pos;

    public MinHeap(int size){
        pos = 1;                // punta all'ultimo indice dell'array *usato*
        capacity = size;
        theHeap = new int[capacity];
    }

    public void insert(int val){
        if (pos == capacity){
            System.err.println("max capacity reached");
        }else{
            theHeap[pos++] = val;
            int child = pos - 1;
            int parent = child / 2;

            while (theHeap[parent] > theHeap[child] && parent > 0){
                int tmp = theHeap[parent];
                theHeap[parent] = theHeap[child];
                theHeap[child] = tmp;

                child = parent;
                parent = child / 2;
            }
        }
    }

    public void printStructure(){
        System.out.print("The content of the minheap is: ");
        /*for (int i : theHeap)
            System.out.print(i + "\t");*/

        for (int i = 1; i < pos; i++){
            System.out.print(theHeap[i] + "\t");
        }
    }
}
