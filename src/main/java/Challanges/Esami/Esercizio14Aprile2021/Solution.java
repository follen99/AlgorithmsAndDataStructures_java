/**
 * @author giuliano ranauro
 * Date: 12/10/2021 12:06
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Challanges.Esami.Esercizio14Aprile2021;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7,4,6,9,3,1,15,8,11,5};

        /*int[] elements = sort(arr, 3);
        for (int el : elements)
            System.out.println(el);*/

        for (int val : arr)
            Tree.add(val);

        Tree.printK(3);

    }

    private static int[] sort(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i<arr.length; i++){
            queue.add(arr[i]);
        }

        int[] elements = new int[k];
        for (int i = 0; i<k; i++){
            elements[i] = queue.poll();
        }
        return elements;
    }
    
    private static class Tree{
        private static class Node{
            private int val;
            private Node left, right;
            
            public Node(int val){
                this.val = val;
            }
        }
        
        private static Node root;
        private static int count;
        
        public static void add(int val){
            root = addRecursive(root, val);
        }
        private static  Node addRecursive(Node current, int val){
            if (current == null)
                return new Node(val);
            if (val < current.val)
                current.left = addRecursive(current.left, val);
            if (val > current.val)
            current.right = addRecursive(current.right, val);
            
            return current;
        }
        
        public static void printK(int k){
            printRecursive(root,k);
        }
        
        private static void printRecursive(Node current, int k){
            if (current != null){
                printRecursive(current.left, k);
                if(count<k){
                    System.out.println(current.val);
                    count++;
                }
                printRecursive(current.right, k);
            }
        }
        
    }


}
