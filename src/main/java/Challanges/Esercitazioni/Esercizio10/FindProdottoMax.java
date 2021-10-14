package Challanges.Esercitazioni.Esercizio10;

import MeasuringTime.Stopwatch.Stopwatch;

import java.util.Arrays;
import java.util.Random;

/**
 * L'obbiettivo è trovare i due numeri che moltiplicati tra loro hanno il prodotto massimo all'interno dell'array
 *
 * Il piano base è quello di selezionare i due numeri piu grandi (ed i due più piccoli qualora fossero negativi) moltiplicare le coppie e poi ritornare
 * la coppia avente il risultato più grande
 * */
public class FindProdottoMax {
    private int[] arr;

    public FindProdottoMax(int[] arr){
        this.arr = arr;
    }

    public int[] findElementsSelection(){
        int[] maxTwo = new int[2];
        int[] minTwo = new int[2];

        maxTwo[0] = 0; //massimo dopo l'assoluto
        maxTwo[1] = arr[0]; //massimo assoluto
        minTwo[0] = 0;
        minTwo[1] = arr[0];

        for (int i = 0; i<arr.length; i++){
            if (arr[i] > maxTwo[1]){
                maxTwo[0] = maxTwo[1];
                maxTwo[1] = arr[i];
            }

            if (arr[i] > maxTwo[0] && arr[i] < maxTwo[1])
                maxTwo[0] = arr[i];

            if (arr[i] < minTwo[1]){
                minTwo[0] = minTwo[1];
                minTwo[1] = arr[i];
            }

            if (arr[i] < minTwo[0] && arr[i] > minTwo[1])
                minTwo[0] = arr[i];
        }

        if ((maxTwo[0] * maxTwo[1]) > (minTwo[0] * minTwo[1])){
            System.out.println("I due elementi che moltiplicati danno il valore maggiore sono: " +
                    maxTwo[1] + " * " + maxTwo[0] + ".");
            return maxTwo;
        }
        System.out.println("I due elementi che moltiplicati danno il valore maggiore sono: " +
                minTwo[1] + " * " + minTwo[0] + ".");
        return minTwo;
    }

    /**
     * Questa è la soluzione proposta dal professore nell'esercitazione, a parer mio inutilmente lenta.
     * é più lenta perchè va ad ordinare tutto l'array, cosa che a noi non serve.
     * Noi vogliamo sapere solo i due elementi più piccoli e più grandi, ed ordinare tutto l'array è inutile.*/
    public void findElementsSorting(){
        int n = arr.length;

        Arrays.sort(arr);

        if (arr[0] * arr[1] > arr[n-1] * arr[n-2])
            System.out.println("La coppia con moltiplicazione maggiore è: " + arr[0] + " , " + arr[1]);
        else System.out.println("La coppia con moltiplicazione maggiore è: " + arr[n-1] + " , " + arr[n-2]);
    }


    public static void main(String[] args) {
        //int[] arr = {5,4,-10,3,1};

        int size = 1000000000;
        int[] arr = new int[size];

        Random rand = new Random();
        for (int i = 0 ; i<size; i++){
            arr[i] = rand.nextInt();
        }

        FindProdottoMax max = new FindProdottoMax(arr);

        Stopwatch stopwatchFirst = new Stopwatch();
        max.findElementsSelection();
        System.out.println(stopwatchFirst.elapsedTime());
        // per un numero di elementi pari a 10000000 l'algoritmo completa in 0.016s
        // per un numero di elementi pari a 1000000000 l'algoritmo completa in 0.938s

        Stopwatch stopwatchSecond = new Stopwatch();
        max.findElementsSorting();
        System.out.println(stopwatchSecond.elapsedTime());
        // per un numero di elementi pari a 10000000 l'algoritmo completa in 0.839s
        // per un numero di elementi pari a 1000000000 l'algoritmo completa in 91.119s, un tempo enormemente maggiore del primo algoritmo.
    }
}
