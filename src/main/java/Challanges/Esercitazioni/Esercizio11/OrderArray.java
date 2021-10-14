package Challanges.Esercitazioni.Esercizio11;
/**
 * Dato una rray in cui tutti gli elementi, eccetto due (che sono scambiati di posto),
 * siano ordinati in maniera crescente, ordinare l'array in un tempo lineare.
 * Assumere che non ci siano valori duplicati nell'array.
 *
 * Esempio: [3, 8 ,6,7, 5 ,9] oppure [3,5,6, 9 ,8, 7 ]*/
public class OrderArray {
    private static void orderArray(int[] arr){
        int len = arr.length;

        int firstIndex = -1;
        int secondIndex = -1;


        for (int i = 0; i < len; i++){
            if (i == 0 && arr[i] > arr[i+1]) {
                firstIndex = 0;
            }
            if (i == len-1 && arr[i] < arr[i-1]) {
                secondIndex = len-1;
                //scambio ed esco se trovo gli elementi prima di finire il ciclo
                if (firstIndex >= 0){
                    swap(arr, firstIndex, secondIndex);
                    return;
                }
            }

            if (i > 0 && i < len-1 && arr[i] > arr[i+1]){
                if (arr[i] > arr[i-1] && !(firstIndex >= 0)){
                    firstIndex = i;
                }
            }

            if (i > 0 && arr[i] < arr[i-1]){
                if (i < len -1 && arr[i] < arr[i-1] && i != firstIndex + 1) {
                    secondIndex = i;
                    //scambio ed esco se trovo gli elementi prima di finire il ciclo
                    if (firstIndex >= 0){
                        swap(arr, firstIndex, secondIndex);
                        return;
                    }
                }
            }
        }
        swap(arr, firstIndex, secondIndex);
    }
    private static void swap(int[] arr, int first, int second){
        /*second = first + second; // 5 + 3 = 8 -> second = 8 first = 5
        first = second - first;  // 8 - 5 = 3 -> first = 3 second = 8
        second = second - first; // 8 - 3 = 5 -> first = 3 second = 5*/
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = {3,8,6,7,5,9};        // caso in cui gli elementi sono interni
        //int[] arr = {8,3,6,7,2,9};        // caso in cui uno dei due elementi è alla posizione 0
        int[] arr = {3,8,5,6,7,4};          // caso in cui uno dei due elementi è all'ultima posizione
        //int[] arr = {10,3,6,7,9,2};       // caso in cui entrambi gli elementi sono agli estremi

        OrderArray.orderArray(arr);

        for (int el : arr)
            System.out.print(el+" ");
    }
}

