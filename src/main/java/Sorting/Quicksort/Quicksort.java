package Sorting.Quicksort;

public class Quicksort {
    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int low, int high){
        if (low < high){
            int partitionIndex = partition(arr, low, high);

            sort(arr, low, partitionIndex-1);
            sort(arr, partitionIndex+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i ++;
                swap(arr, j, i);
            }
        }

        swap(arr, i+1, high);
        return i +1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
