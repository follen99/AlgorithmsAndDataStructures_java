/**
 * @author giuliano ranauro
 * Date: 26/10/2021 10:53
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Heaps;

public class TesterHeapArray {
    public static void main(String[] args) {
        HeapArray heapArray = new HeapArray(5);
        heapArray.add(4);
        heapArray.add(3);
        heapArray.add(10);
        heapArray.add(2);
        heapArray.add(8);

        while (heapArray.peek() != null){
            System.out.println(heapArray.poll());
        }
    }
}
