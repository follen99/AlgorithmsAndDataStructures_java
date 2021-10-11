package Challanges.FindDuplicate;

/**
 * Trovare l'elemento duplicato senza usare spazio extra */
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,6};

        System.out.println(findDuplicate(arr));
    }

    /**
     * Questa soluzione è di facile implementazione ma non molto ottimizzata.
     * Deve infatti controllare molti elementi prima di poter trovare un duplicato.
     * */
    private static final int findDuplicate(int[] arr){
        Integer duplicate = -1;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] == duplicate)
                return duplicate;
            duplicate = arr[i];
            for (int j = 0; j< arr.length; j++){
                if (arr[j] == duplicate && j != i)
                    return duplicate;
            }
        }
        return -1;
    }
}
