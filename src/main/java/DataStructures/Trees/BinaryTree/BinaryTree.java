package DataStructures.Trees.BinaryTree;

import DataStructures.Trees.Playground.Tree2;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {
    Node root;
    int count;
    public BinaryTree(int value){
        this.root = new Node(value);
        this.count = 1;
    }
    public BinaryTree(){
        this.count = 0;
    }
    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void add(int element){
        this.root = this.addRecursive(this.root, element);
        this.count++;
    }
    private Node addRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        if (value > current.value)
            current.right = addRecursive(current.right, value);
        return current;
    }
    //DFS
    public void printInOrder(){
        printRecursive(root);
    }
    private void printRecursive(Node current){
        if (current != null){
            printRecursive(current.left);
            System.out.println(current.value);
            printRecursive(current.right);
        }
    }

    public int[] toArray(){
        LinkedList<Integer> list = new LinkedList<>();
        toArrayRecursive(this.root, list);

        int[] arr = new int[this.count];
        int i = 0;

        while (!list.isEmpty() && list.peekFirst() != null){
            arr[i] = list.pop();
            i++;
        }

        return arr;
    }
    private void toArrayRecursive(Node current, LinkedList list){
        if (current != null){
            toArrayRecursive(current.left, list);
            list.add(current.value);
            toArrayRecursive(current.right,list);
        }
    }

    public void delete(int value){
        root = deleteRecursive(this.root, value);
    }

    private Node deleteRecursive(Node current, int value){
        if (current==null)
            return null;

        if (current.value == value){
            //nel caso in cui l'el da eliminare non ha figli ritorno null
            if (current.left == null && current.right == null)
                return null;

            //nel caso in cui l'el da eliminare ha solo un figlio ritorno quello non null
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;


            int smallest = this.findSmallest(current.right); //trovo il figlio piu piccolo del nodo destro
            current.value = smallest;   //sostituisco
            current.right = deleteRecursive(current.right, smallest); //dopodichè elimino l'elemento appena messo al posto di current
            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallest(Node root){
        return root.left == null
                ? root.value
                : findSmallest(root.left);
    }


}

