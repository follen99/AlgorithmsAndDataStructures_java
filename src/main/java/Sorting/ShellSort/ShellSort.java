/**
 * @author giuliano ranauro
 * Date: 09/10/2021 15:44
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.ShellSort;

public class ShellSort {
    public ShellSort(){}

    public static void sort(int[] arrayToSort){
        int n = arrayToSort.length;     //size

        /**
         * il "gap" è il salto da fare ad ogni iterazione.
         * Ad ogni iter esso viene dimezzato.
         * */
        for (int gap = n / 2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i++){
                int key = arrayToSort[i];
                int j = i;

                while (j >= gap && arrayToSort[j - gap] > key){
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
    }
}
