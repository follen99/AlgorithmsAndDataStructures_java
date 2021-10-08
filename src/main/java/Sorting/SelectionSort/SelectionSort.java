/**
 * @author giuliano ranauro
 * Date: 08/10/2021 18:39
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.SelectionSort;

public class SelectionSort {
    public SelectionSort(){}

    public static void sort(Comparable[] array){
        int len = array.length;
        for (int i = 0; i<len; i++){
            int min = i;
            for (int j = i+1; j< len; j++){
                if (less(array[j], array[min]))
                    min = j;
            }
            if (min != i){
                Comparable swap = array[min];
                array[min] = array[i];
                array[i] = swap;
            }
        }

    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
}
