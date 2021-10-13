package Challanges.Esercitazioni.Esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        int[] arr = {3,5,5,3,4,7,4};
        System.out.println(FindTimes.find(arr));        //true

        int[] arr1 = {5,5,3,4,4,7,7,7,7,4};
        System.out.println(FindTimes.find(arr1));       //false
    }
}

