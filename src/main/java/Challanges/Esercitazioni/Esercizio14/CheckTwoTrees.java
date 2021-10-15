package Challanges.Esercitazioni.Esercizio14;

public class CheckTwoTrees {
    public static class Tree{
        private Node root;
        private int nodeCount;

        private boolean areEqual;

        private class Node{
            private int value;
            private Node left;
            private Node right;

            public Node(){}
            public Node(int value){
                this.value = value;
            }
        }

        public Tree(){
            this.nodeCount = 0;
        }

        public void add(int value){
            this.root = addRecursive(this.root, value);
        }
        private Node addRecursive(Node current, int val){
            if (current == null)
                return  new Node(val);

            if (val < current.value)
                current.left = addRecursive(current.left, val);

            if (val > current.value)
                current.right = addRecursive(current.right, val);

            return current;
        }

        public boolean compareWithOtherTree(Tree otherTree){
            this.areEqual = true;
            compareRecursive(this.root, otherTree.root);
            return areEqual;
        }

        /**
         * Il metodo è la DFS modificata per analizzare elemento per elemento di entrambi i nodi nel seguente modo:
         * */
        private void compareRecursive(Node current1, Node current2){
            if (current1 != null){      // se il nodo corrente è null mi fermo (sono giunto alla fine) -> jump to last if
                if (current2 != null) {
                    if (!(current1.value == current2.value))
                        this.areEqual = false;                          // se i valori dei due nodi sono diversi, gli alberi sono diversi
                    compareRecursive(current1.left, current2.left);     // controllo il sottoalbero sinistro
                    compareRecursive(current1.right, current2.right);   // controllo il sottoalbero destro
                }else this.areEqual = false;                    // se il primo nodo non è null ma il secondo si, i due alberi sono diversi.
            }else if (current2 != null) this.areEqual = false;  // se il primo nodo è null ma il secondo no, i due alberi sono diversi.
        }

        /*
        Qui ho provato a fare lo stesso metodo senza usare una variabile di istanza, senza molto successo
        private boolean compareRecursive(Node current1, Node current2, boolean areEquals){
            if (current1 != null){      // se il nodo corrente è null mi fermo (sono giunto alla fine) -> jump to last if
                if (current2 != null) {
                    if (!(current1.value == current2.value)) {
                        areEquals = false;                          // se i valori dei due nodi sono diversi, gli alberi sono diversi
                    }
                    areEquals = compareRecursive(current1.left, current2.left, areEquals);     // controllo il sottoalbero sinistro
                    areEquals = compareRecursive(current1.right, current2.right, areEquals);   // controllo il sottoalbero destro
                }else{
                    areEquals = false;                    // se il primo nodo non è null ma il secondo si, i due alberi sono diversi.
                }
            }else if (current2 != null){
                areEquals = false;  // se il primo nodo è null ma il secondo no, i due alberi sono diversi.
            }

            return areEquals;
        }

         */

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(2);
        tree.add(10);
        tree.add(25);
        tree.add(200);

        Tree tree1 = new Tree();
        tree1.add(5);
        tree1.add(2);
        tree1.add(10);
        tree1.add(25);
        tree1.add(200);


        System.out.println(tree.compareWithOtherTree(tree1));   // stampa true

    }
}

