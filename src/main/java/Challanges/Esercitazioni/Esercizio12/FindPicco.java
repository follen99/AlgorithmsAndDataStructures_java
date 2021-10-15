package Challanges.Esercitazioni.Esercizio12;

public class FindPicco {
    public static int find(int[] arr, int left, int right){
        int mid = (left + right) / 2;

        if((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid])
            return find(arr, left, mid -1);

        return find(arr, mid + 1, right);
    }

    public static int find(int[] arr){
        return find(arr,0, arr.length-1);
    }

    public static void main(String[] args) {
        //int[] arr = {8,9,10,2,5,6};
        int[] arr = {10,8,6,5,3,2};
        //int[] arr = {8,9,10,2,5,6};
        System.out.println(FindPicco.find(arr));;
    }
}
