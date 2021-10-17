package UsefulCode;

public class BinarySearch {
    public static int find(int[] arr, int key){
        int index = -1;
        if (verify(arr)){
            index = find(arr, 0, arr.length - 1, key);
        }
        return index;
    }

    private static int find(int[] arr, int low, int high, int toFind){
        int mid = low + (high - low) / 2;
        if (toFind < arr[mid]){
            return find(arr, low, mid - 1, toFind);
        }
        if (toFind > arr[mid]){
            return find(arr, mid + 1, high, toFind);
        }
        return mid;
    }

    private static boolean verify(int[] arr){
        for (int i = 0; i < arr.length-1 ; i++){
            if (arr[i] > arr[i+1])
                return false;
        }

        return true;
    }
}
