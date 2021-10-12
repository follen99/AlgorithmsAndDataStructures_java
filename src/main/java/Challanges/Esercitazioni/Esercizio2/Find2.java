package Challanges.Esercitazioni.Esercizio2;
/**
 * Devo trovare le occorrenze di un array ordinato in modo crescente composto solo dai numeri 1, 2 ,3.
 * la complessità temporale deve essere di O(log n)
 * un array tipo potrebbe essere: {1,1,1,1,1,2,2,2,3,3,3,3,3}
 * Per avere un tempo linearitmico devo dividere sempre l'array.
 *
 * */
public class Find2 {
    public static int find2(int[] arr){
        int fineUno;
        int fineDue;


        if (arr[arr.length-1] == 1)
            //non ci sono 2
            return 0;

        if (arr[0] == 2)
            //non ci sono 1
            fineUno = 0;
        else {
            fineUno = lastX(arr, 1, 1, arr.length-1);
        }

        if (arr[arr.length-1] == 2){
            fineDue = arr.length-1;
        }else {
            fineDue = lastX(arr, 2, 0, arr.length-1 -1);
        }
        return (fineDue-fineUno);   //ritorno il conto


    }

    private static int lastX(int[] arr, int x, int i, int j) {
        if (i > j)
            return -1;

        int m = (i+j)/2;
        if (arr[m] == x && arr[m+1] > x)
            return m;
        if (arr[m] > x)
            return lastX(arr, x, i, m-1);
        else return lastX(arr, x, m+1, j);
    }
}
