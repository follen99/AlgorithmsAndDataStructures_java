package Challanges.Esercitazioni.Esercizio15;

import MeasuringTime.Stopwatch.Stopwatch;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Questa è la soluzione più efficiente del problema 15.
 * Invece di ordinare gli arrays, metterli in due code e poi controllare il più piccolo,
 * ci basta semplicemente usare una priorityQueue.
 * Non so come ho fatto a pensare a due Queue e non ad una PQ...
 * */
public class SoluzioneSemplice {
    public static void printMergedArrays(int[] arr1, int[] arr2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = arr1.length;
        for (int i = 0; i < m; i++){
            pq.add(arr1[i]);
            pq.add(arr2[i]);
        }

        for (int i = 0; i < m*2; i++)
            System.out.println(pq.poll());
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = arr1.length;
        for (int i = 0; i < m; i++){
            pq.add(arr1[i]);
            pq.add(arr2[i]);
        }

        int[] result = new int[m*2];

        for (int i = 0; i <(m*2) - 1; i++)
            result[i] = pq.poll();


        return result;

    }

    public static void main(String[] args) {
        /*int[] arr1 = {1,4,5};
        int[] arr2 = {2,10,6};

        SoluzioneEfficiente.mergeArraysOrdinati(arr1,arr2);
         */

        int m = 50000000;
        int[] arr1 = new int[m];
        int[] arr2 = new int[m];

        Random random = new Random();
        for (int i = 0; i < m; i++){
            arr1[i] = random.nextInt();
            arr2[i] = random.nextInt();
        }

        Stopwatch sw = new Stopwatch();
        int[] result = mergeArrays(arr1,arr2);
        double time = sw.elapsedTime();

        System.out.println("\nTempo impiegato: "+time); // Tempo impiegato: 177.85 s con 50000000
        /**
         * wow non mi sarei mai aspettato che questa soluzione fosse MOLTO MENO efficiente di quella che avevo scritto in precedenza.
         * Il motivo può solo essere il fatto che le PQ sono molto meno efficienti dell'algoritmo usato da java per ordinare
         * gli arrays (quicksort) */
    }
}
