package DataStructures.Trees.BinaryTree;

import DataStructures.Trees.Playground.Tree2;

import java.util.LinkedList;
import java.util.Stack;

public class Tester {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(1);

        //tree.printInOrder();

        tree.delete(5);


        int[] arr = tree.toArray();

        for (int element : arr)
            System.out.println(element);

        /*tree.delete(4);

        tree.printAll();

        System.out.println(tree.findRecursive(50));*/

    }
}
