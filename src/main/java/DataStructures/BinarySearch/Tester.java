/**
 * @author giuliano ranauro
 * Date: 08/10/2021 16:19
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.BinarySearch;

public class Tester {
    public static void main(String[] args) throws Exception {
        BinarySearch search = new BinarySearch();

        int[] array = new int[10];

        for (int i = 0; i<9; i++){
            array[i] = i;
        }

        int pos = search.find(array, 0);
        System.out.println("L'elemento si trova nella posizione: "+pos);
    }

}
