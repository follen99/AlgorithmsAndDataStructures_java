package UsefulCode;

public class QuickSort {
    public static void sort(int[] arr){
        quickSort(arr,0,arr.length - 1);
    }

    private static void quickSort(int[] arr, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(arr,begin,end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end){
        int pivot = arr[end];
        int i = begin-1;

        for (int j = begin; j < end; j++){
            if (arr[j] < pivot){
                i++;

                swap(arr, i,j);
            }
        }

        swap(arr, i+1, end);


        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
