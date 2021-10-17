package UsefulCode;

public class MasterTester {
    public static void main(String[] args) {

        // ################ SELECTION SORT ####################

        int[] arr = {7,2,1,8,6,3,5,4};
        SelectionSort.sort(arr);
        for (int i : arr)
            System.out.println(i);
        // ################ SELECTION SORT ####################

        // ################ BINARY SEARCH ####################
        int[] sorted = {1,5,7,10,33,43,45,62,100,210};
        System.out.println("Il numero cercato è alla posizione: " + BinarySearch.find(sorted, 62));
        // ################ BINARY SEARCH ####################

        // ################ BST ####################
        BinaryTree tree = new BinaryTree();
        tree.add(7);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(3);
        tree.add(5);
        tree.add(4);

        tree.DFS();

        tree.delete(3);
        tree.DFS();

        // ################ BST ####################
    }
}
