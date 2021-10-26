/**
 * @author giuliano ranauro
 * Date: 26/10/2021 10:28
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Heaps;

public class HeapArray {
    private Integer[] arr;
    private int size;
    private int capacity;   // tiene traccia del massimo numero di elementi della struttura

    public HeapArray(int size){
        this.arr = new Integer[size];
        this.size = 0;
        this.capacity = size;
    }

    public boolean hasLeftChild(int index){
        if (size > getLeftChildIndex(index))
            return arr[(index * 2) + 1] != null;
        return false;
    }
    public Integer leftChild(int index){
        return arr[(index * 2) + 1];
    }
    public int getLeftChildIndex(int index){
        return (index * 2) + 1;
    }
    public boolean hasRightChild(int index){
        if (size > getRightChildIndex(index))
            return arr[(index * 2) + 2] != null;
        return false;
    }
    public Integer rightChild(int index){
        return arr[(index * 2) + 2];
    }
    public int getRightChildIndex(int index){
        return (index * 2) + 2;
    }
    public boolean hasParent(int index){
        if (index > 0)
            return arr[(index - 2) / 2] != null;
        return false;
    }
    public Integer parent(int index){
        return arr[(index - 2) / 2];
    }
    public int getParentIndex(int index){
        return (index - 2) / 2;
    }

    public void swap(int i, int j){
        Integer temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }



    public Integer peek(){
        if (size == 0) throw new IllegalStateException("The data structure is empty!");
        return this.arr[0];
    }

    public Integer poll(){
        if (size == 0) throw new IllegalStateException("The data structure is empty!");
        Integer item = this.arr[0];

        this.arr[0] = this.arr[size - 1];
        size--;

        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        int index = 0;  // root
        // se non è presente il figlio sinistro sicuramente non c'è nemmeno il destro
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);

            // se è presente un nodo destro, e questo è ancora più piccolo del figlio sinistro, allora l'indice del figlio minore è il destro.
            if (hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if (this.arr[index] < this.arr[smallerChildIndex]){
                break;
            }else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void add(int item){
        if (size == capacity)
            throw new  IllegalStateException("The data structure is full!");

        this.arr[size] = item;
        size ++;

        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > this.arr[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
}
