package DataStructures.Trees.Playground;

public class Tree2 {
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

    Node root;

    public void add(int value){
        root = addRecursive(this.root, value);
    }

    private Node addRecursive(Node current, int value){
        if (current == null)
            return new Node(value);

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);
        else return current;

        return current;
    }

    public void printAll(){
        printRecursive(this.root);
    }
    /**
     * DEPTH FIRST SEARCH - DFS*/
    private void printRecursive(Node node){
        if (node != null) {
            printRecursive(node.left);  // Il metodo stamperà sempre prima gli elementi a sinistra partendo dal più piccolo di ogni sottoalbero
            System.out.println(node.value);
            printRecursive(node.right); //solo dopo aver stampato tutti gli elementi a sinistra inizierà a stampare gli elementi a destra
        }
    }

    public boolean findRecursive(int element){
        return findRecursive(this.root,element);
    }

    private boolean findRecursive(Node current, int element) {
        if (current == null)
            return false;
        if (current.value == element)return true;
        return element < current.value
                ? findRecursive(current.left, element)           //se l'el da cercare è minore di curr allora cerco a sinistra
                : findRecursive(current.right, element);         //se l'el è più grande cerco a destra
    }

    public void delete(int value){
        root = deleteRecursive(this.root, value);
    }

    private Node deleteRecursive(Node current, int element){
        if (current == null)
            return null;
        if (current.value == element){
            //non ha figli, non ritorniamo nulla (caso più semplice)
            if (current.left == null && current.right == null)
                return null;
            //ha solo uno dei due figli, ritorniamo quello non null
            if (current.right == null)
                return current.left;
            if (current.left == null)
                return current.right;

            //ha entrambi i figli, dobbiamo prima trovare il figlio più piccolo del figlio destro:
            int smallest = findSmallestValue(current.right);
            current.value = smallest;   //una volta trovato lo assegnamo al nodo corrente
            current.right = deleteRecursive(current.right, smallest);   //dopodichè eliminiamo il nodo destro del nodo corrente
            return current;
        }
        if (element < current.value){
            current.left = deleteRecursive(current.left, element);
            return current;
        }
        current.right = deleteRecursive(current.right, element);
        return current;
    }

    private int findSmallestValue(Node root){
        return root.left == null
                ? root.value
                : findSmallestValue(root.left);
    }
}
