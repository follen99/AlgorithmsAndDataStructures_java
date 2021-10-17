package Sorting.Quicksort;

public class Tester {
    public static void main(String[] args) {
        int[] arr = {2,6,5,3,8,7,1,0};
        Quicksort.sort(arr);

        for (int i : arr)
            System.out.println(i);
    }
}
