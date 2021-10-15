package Challanges.Esercitazioni.Esercizio13;

import java.util.TreeSet;

public class CalcImbalance {
    public static class Tree{
        private Node root;
        private int tempCount;

        private class Node{
            private int value;
            private Node left;
            private Node right;

            public Node(){}
            public Node(int value){
                this.value = value;
            }
        }

        public void add(int val){
            this.root = add(this.root,val);
        }
        private Node add(Node curr, int val){
            if (curr == null){
                return new Node(val);
            }
            if (val < curr.value){
                curr.left = add(curr.left,val);
            }
            if (val > curr.value){
                curr.right = add(curr.right,val);
            }

            return curr;
        }

        public void printAll(){
            printDFS(this.root);
        }
        private void printDFS(Node current){
            if (current != null){
                printDFS(current.left);
                System.out.println(current.value);
                printDFS(current.right);
            }
        }

        public int calcImbalance(){
            int count1 = calcImbalance(root.left,0);
            System.out.println("foglie a sinistra: "+count1);
            int count2 = calcImbalance(root.right,0);
            System.out.println("foglie a destra: "+count2);

            if (count1 - count2 < 0)
                return (count1-count2) * -1;
            return count1 - count2;
        }
        private int calcImbalance(Node current, int count){
            if (current != null){
                if (current.left == null && current.right == null)
                    count ++;
                count = calcImbalance(current.left, count);

                count = calcImbalance(current.right, count);
            }

            return count;
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(6);
        tree.add(2);
        tree.add(10);
        tree.add(20);
        tree.add(18);
        tree.add(50);
        tree.add(30);
        tree.add(51);

        tree.printAll();

        System.out.println("The imbalance of the tree is: " + tree.calcImbalance());;

    }
}


