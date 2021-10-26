/**
 * @author giuliano ranauro
 * Date: 08/10/2021 17:59
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Heaps.HeapSort;

public class Tester {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];

        /*Random random = new Random();

        for (int i = 0; i<5; i++){
            array[i] = random.nextInt(100);
        }*/

        array[0] = 30;
        array[1] = 20;
        array[2] = 3;
        array[3] = 11;
        array[4] = 50;

        Heap heap = new Heap();
        heap.sort(array);

        heap.show(array);

    }
}
