package Challanges.ScrapExcercises.BST;

public class Tester {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(50);
        bst.insert(2);
        bst.insert(18);
        bst.insert(11);
        bst.insert(150);
        bst.insert(1);

        bst.printAllInOrder();

        bst.delete(18);

        System.out.println("\n\n\n\n");

        bst.printAllInOrder();
    }
}
