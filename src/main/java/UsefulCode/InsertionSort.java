package UsefulCode;

public class InsertionSort {
    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];               //salvo l'elemento corrente
            int j = i -1;

            while (j >= 0 && arr[j] > key){ //mi fermo quando raggiungo l'inizio dell'array oppure gli elementi sono in ordine
                arr[j + 1] = arr[j];        //sovrascrivo j+1, ma alla fine del loop lo sostituisco con il salvataggio.
                j--;                        //decremento finchè non finisce il loop, continuando così a scambiare.
            }
            arr[j + 1] = key;               //alla fine sostituisco l'elemento sovrascritto
        }
    }
}
