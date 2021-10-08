/**
 * @author giuliano ranauro
 * Date: 08/10/2021 18:50
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.SelectionSort;

public class SelectionSortNumbers {
    public SelectionSortNumbers(){}

    public static void sort(int[] numbers){
        for (int i = 0; i<numbers.length-1; i++){
            int min = i;    //assumiamo che il primo sia il più piccolo, poi lo cambiamo
            for (int j = i+1; j<numbers.length; j++){
                if (!(numbers[min]<numbers[j]))
                    min = j;
            }
            //swap
            int temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
    }
}
