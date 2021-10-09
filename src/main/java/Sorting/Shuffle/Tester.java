/**
 * @author giuliano ranauro
 * Date: 09/10/2021 16:06
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.Shuffle;

public class Tester {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        ShuffleSort.sort(numbers);
        for (int num : numbers)
            System.out.println(num);
    }


}
