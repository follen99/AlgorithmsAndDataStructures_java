package UsefulCode;

public class BinaryTree {
    private Node root;

    public BinaryTree(){}
    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }



    public void add(int val){
        this.root = add(this.root, val);
    }

    private Node add(Node current, int val){
        if (current == null){
            return new Node(val);
        }

        if (val < current.value){
            current.left = add(current.left, val);
        }else if(val > current.value){
            current.right = add(current.right, val);
        }

        return current;
    }

    public void DFS(){
        System.out.print("Binary tree content: ");
        depthFirstSearch(this.root);
        System.out.println("\n");
    }

    private void depthFirstSearch(Node current){
        if (current != null){
            depthFirstSearch(current.left);
            // do your stuff here
            System.out.print(current.value + "\t");
            depthFirstSearch(current.right);
        }
    }

    public void delete(int val){
        deleteRecursive(this.root, val);
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

    private int findSmallest(Node current){
        if (current.left == null)
            return current.value;
        return findSmallest(current.left);
    }
}
