package UsefulCode;

public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int min = i;
            for (int j = i; j < arr.length-1; j++){
                if (arr[min] > arr[j])
                    min = j;
            }

            swap(arr,min,i);
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
