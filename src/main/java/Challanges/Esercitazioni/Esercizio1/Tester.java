package Challanges.Esercitazioni.Esercizio1;

public class Tester {
    public static void main(String[] args) {
        Comparable[] arr = {2,5,1,20,98,56,23,18};

        BinaryInsertion.sort(arr);

        for (Comparable el : arr)
            System.out.println(el);

    }
}
