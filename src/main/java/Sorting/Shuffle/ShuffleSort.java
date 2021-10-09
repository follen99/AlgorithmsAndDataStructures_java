/**
 * @author giuliano ranauro
 * Date: 09/10/2021 16:04
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.Shuffle;

public class ShuffleSort {
    public ShuffleSort(){}

    public static void sort(int[] array){
        int size = array.length;
        for (int i = 0; i<size; i++){
            int temp = array[i];
            int swap = getRandom(0, size);
            array[i] = array[swap];
            array[swap] = temp;
        }
    }

    private static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
