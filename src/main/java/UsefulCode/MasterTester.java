package UsefulCode;

public class MasterTester {
    public static void main(String[] args) {

        // ################ SELECTION SORT ####################
        int[] arr = {7,2,1,8,6,3,5,4};
        SelectionSort.sort(arr);
        for (int i : arr)
            System.out.println(i);
        // ################ SELECTION SORT ####################


    }
}
