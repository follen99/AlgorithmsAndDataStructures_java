package Challanges.Esercitazioni.Esercizio1;

import java.util.Comparator;

public class BinaryInsertion {
    public static void sort(Comparable[] a){
        int n = a.length;

        for (int i = 1; i<n; i++){
            Comparable v = a[i];
            int lo = 0, hi = i;     //gap tra 0 ed elemento corrente

            while (lo < hi){
                int mid = lo + (hi - lo) / 2;

                if (v.compareTo(a[mid]) < 0)
                    hi  = mid;  //metà inferiore
                else lo = mid + 1;  //metà superiore
            }

            for (int j = i; j > lo; --j){
                a[j] = a[j-1];
            }
            a[lo] = v;
        }

    }
}
