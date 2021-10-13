package Challanges.Other.SortArrayLinearTime;

import MeasuringTime.Stopwatch.Stopwatch;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        Random random = new Random();
        for(int i = 0; i<100000000-1; i++){
            arr[i] = random.nextInt(2);
        }


        Stopwatch stopwatch = new Stopwatch();      //avvio lo stopwatch
        //int[] arr = {1,0,1,0,1,0,0,1};

        sort(arr);        //sort implementato da me (lineare)
        //bubbleSort(arr);    //bubblesort
        //InsertionSort.sort(arr);  //insertion sort, molto lento


        double time = stopwatch.elapsedTime();      //fermo lo stopwatch per vedere il tempo impiegato

        System.out.println("elapsed time: "+time);

        /*for (int num : arr)
            System.out.println(num);*/

    }

    /**
     * visto che il problema ci chiede di ordinare in tempo lineare l'array, e ci fornisce l'array,
     * possiamo contare il numero di zero e metterli all'inizio dell'array.
     *
     * Tempo di esecuzione per 100000000 elementi 0.11 secondi con i5 9400*/
    private static void sort(int[] arr){
        int zeros = 0;
        int len = arr.length;

        for (int i = 0; i<len; i++){
            if (arr[i] == 0)
                zeros ++;
        }

        for (int i = 0; i<len; i++){
            if (zeros > 0) {
                arr[i] = 0;
                zeros--;
                continue;
            }
            arr[i] = 1;
        }
    }

    /**
     * BubbleSort, implementato per vedere le differenze.
     * Tempo di esecuzione: sono 5 minuti e ancora non ha finito, con 100000000 elementi.
     * */
    private static void bubbleSort(int[] arr){
        for (int i = 0; i<arr.length; i++){
            for (int j = 1; j<arr.length; j++){
                if (arr[j-1] > arr[j])
                    swap(arr, j, j-1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
