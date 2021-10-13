package Challanges.Other.ScrapExcercises.BST;

public class BinarySearchTree {
    public class Node{
        private Node left, right;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree(){

    }

    public void insert(int value){
        this.root = insertRecursive(this.root, value);
    }
    private Node insertRecursive(Node current, int val){
        if (current == null)
            return new Node(val);
        if (val < current.value)
            current.left =  insertRecursive(current.left,val);
        if (val > current.value)
            current.right = insertRecursive(current.right, val);


        return current;
    }


    public void printAllInOrder(){
        printRecursive(this.root);
    }
    private void printRecursive(Node current){
        if (current!=null){
            printRecursive(current.left);
            System.out.println(current.value);
            printRecursive(current.right);
        }
    }

    public void delete(int val){
        root = deleteRecursive(root, val);
    }


    private Node deleteRecursive(Node current, int val){
        if(current == null)
            return null;

        if (current.value == val){
            if (current.left == null && current.right == null)
                return null;
            if (current.left != null)
                return current.left;
            if (current.right != null)
                return current.right;

            int smallest = findSmallest(current.right);
            current.value = smallest;   //sostituisco il valore corrente con il più piccolo
            current.right = deleteRecursive(current.right, smallest);
            return current;
        }

        if (val < current.value) {
            current.left = deleteRecursive(current.left, val);
            return current;
        }
        current.right = deleteRecursive(current.right, val);
        return current;
    }

    private int findSmallest(Node current){
        if (current.left == null)
            return current.value;
        return findSmallest(current.left);
    }
}
