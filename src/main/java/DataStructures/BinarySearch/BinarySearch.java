/**
 * @author giuliano ranauro
 * Date: 08/10/2021 16:07
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.BinarySearch;

/**
 * Partiamo dal presupposto che l'array sia già ordinato.
 * confrontiamo la chiave con l'elemento centrale dell'array
 * se troppo grande, cercare a sinistra.
 * se troppo piccolo, cercare a destra
 * se è uguale abbiamo trovato l'elemento.*/

public class BinarySearch {

    public BinarySearch(){}

    public int find(int[] array, int key) throws Exception {
        int lo = 0;                 //primo elemento
        int hi = array.length-1;    //ultimo elemento

        while (lo <= hi){
            int mid = lo + (hi-lo) / 2;     //per trovare l' INDICE medio
            if (key > array[mid])
                lo = mid + 1;
            else if (key < array[mid])
                hi  = mid - 1;
            else return mid;                //nel caso in cui non è nè maggiore nè minore allora è uguale
        }
        throw new Exception("Unexpected exception.");
    }

}
