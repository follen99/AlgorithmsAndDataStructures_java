/**
 * @author giuliano ranauro
 * Date: 09/10/2021 15:48
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Sorting.ShellSort;

public class Tester {
    public static void main(String[] args) {
        /*
        too easy
        int[] numbers = new int[5];
        numbers[0] = 30;
        numbers[1] = 20;
        numbers[2] = 3;
        numbers[3] = 11;
        numbers[4] = 50;

        ShellSort.sort(numbers);

        for (int num : numbers)
            System.out.println(num);*/

        int[] input = {41, 15, 82, 5, 65, 19, 32, 43, 8};
        ShellSort.sort(input);

        for (int num : input)
            System.out.println(num);
    }
}
