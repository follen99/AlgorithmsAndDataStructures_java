package DataStructures.Trees.Playground;

public class Tree1 {
    private Node root;

    public class Node{
        private int val;
        private Node left;
        private Node right;
        /**
         * un nodo ha un VALORE e due figli, uno sinistro ed uno destro*/
        public Node(){}
        public Node(int value){
            this.val = value;
        }
    }
    public  Tree1(){}

    public void add(int value){
        if (this.root == null){
            this.root = new Node(value);
            return;
        }
        /**
         * il problema di base è che inserisce sempre a sinistra.*/
        Node check = this.root;
        while (true){
            if (check.left == null){
                this.root.left = new Node(value);
            }else if (check.right == null)
                this.root.right = new Node(value);
            check = check.left;
            continue;
        }


    }

    /*
    just a test
    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        Node left = new Node();
        left.val = 2;
        Node right = new Node();
        right.val = 3;

        node.left = left;
        node.right = right;

        System.out.println(node.left.val);

    }*/
}
