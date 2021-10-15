package Challanges.Esercitazioni.Esercizio15;

import MeasuringTime.Stopwatch.Stopwatch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class SoluzioneEfficiente {
    // questo metodo funziona anche se gli arrays hanno lunghezza diversa
    public static int[] mergeArrays(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();


        for (int i : arr1){
            queue1.add(i);
        }

        for (int i : arr2){
            queue2.add(i);
        }

        int[] result = new int[arr1.length + arr2.length];
        int a = 0;
        int b = 0;

        for (int i = 0; i < result.length; i++){
            if (queue1.size() == 0){
                if (queue2.size() != 0){
                    result[i] = queue2.remove();
                    continue;
                }
            }else if (queue2.size() == 0){
                result[i] = queue1.remove();
                continue;
            }
            a = queue1.peek();
            b = queue2.peek();

            if (a < b){
                result[i] = queue1.remove();
            }else result[i] = queue2.remove();
        }

        return result;
    }

    public static int[] mergeArraysSameLen(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        int m = arr1.length;


        for (int i = 0; i < m - 1; i++){
            queue1.add(arr1[i]);
            queue2.add(arr2[i]);
        }
        int a = 0;
        int b = 0;

        int[] result = new int[m*2];
        int i = 0;

        while (queue1.peek() != null){
            a = queue1.peek();
            if (queue2.peek() == null) {
                result[i] = queue1.remove();
                return result;
            }
            b = queue2.peek();

            if (a < b){
                result[i] = queue1.remove();
            }else result[i] = queue2.remove();
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        /*int[] arr1 = {1,4,5};
        int[] arr2 = {2,10,6};

        int[] result = MergeArraysCresente.mergeArrays(arr1,arr2);

        for (int i : result)
            System.out.println(i);
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

        //int[] result = SoluzioneEfficiente.mergeArrays(arr1,arr2);          // Tempo impiegato: 12.688 con 50000000 elementi
        int[] result = SoluzioneEfficiente.mergeArraysSameLen(arr1,arr2);       // Tempo impiegato: 12.028 con 50000000 elementi

        double time = sw.elapsedTime();

        /*for (int i : result)
            System.out.println(i);*/

        System.out.println("\nTempo impiegato: "+time); //Tempo impiegato: 2.697 s
    }
}
