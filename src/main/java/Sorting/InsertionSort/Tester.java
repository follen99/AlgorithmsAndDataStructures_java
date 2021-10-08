/**
 * @author giuliano ranauro
 * Date: 08/10/2021 19:16
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.InsertionSort;

public class Tester {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 30;
        numbers[1] = 20;
        numbers[2] = 3;
        numbers[3] = 11;
        numbers[4] = 50;

        InsertionSort.sort(numbers);

        for (int in : numbers)
            System.out.println(in);
    }
}
