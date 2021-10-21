/**
 * @author giuliano ranauro
 * Date: 21/10/2021 21:24
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.SecondTryOptimized;

import java.util.*;

public class Grafo {
    public class Node implements Comparator<Node>, Comparable<Node> {
        private TreeSet<Node> adj;
        private int val;

        public Node(int value){
            this.adj = new TreeSet<>();
            this.val = value;
        }
        public Node(int value, Node adj){
            this.adj = new TreeSet<>();
            this.adj.add(adj);

            this.val = value;
        }

        public void addAdj(Node adj){
            this.adj.add(adj);
        }

        public void removeAdj(Node adj){
            this.adj.remove(adj);
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.val > o2.val)
                return 1;
            else if (o1.val < o2.val)
                return -1;
            return 0;
        }

        @Override
        public int compareTo(Node o2) {
            if (this.val > o2.val)
                return 1;
            else if (this.val < o2.val)
                return -1;
            return 0;
        }
    }

    private HashMap<Integer,Node> edges;

    public Grafo(){
        this.edges = new HashMap<>();
    }

    public void add(int edge1, int edge2){
        Node node1 = null;
        Node node2 = null;


        if (this.edges.containsKey(edge1))
            node1 = this.edges.get(edge1);
        if (this.edges.containsKey(edge2))
            node2 = this.edges.get(edge2);


        //se il nodo 1 è presente
        if (node1 != null){
            //se è presente anche il nodo 2
            if (node2 != null){
                node1.addAdj(node2);
                node2.addAdj(node1);
            }else{
                // se il nodo 2 non è presente
                node2 = new Node(edge2, node1);
                node1.addAdj(node2);

                edges.put(node2.val, node2);
            }
        }else {
            // se il nodo 1 non è presente
            if (node2 != null){
                // se il nodo 1 è presente
                node1 = new Node(edge1, node2);
                node2.addAdj(node1);

                edges.put(node1.val, node1);
            }else{
                // se nemmeno il node 2 è presente
                node1 = new Node(edge1);
                node2 = new Node(edge2);

                node1.addAdj(node2);
                node2.addAdj(node1);

                edges.put(node1.val, node1);
                edges.put(node2.val, node2);
            }
        }
    }

    public void printAll(){
        Set<Map.Entry<Integer, Node>> nodes = this.edges.entrySet();

        for (Map.Entry<Integer, Node> node : nodes){
            System.out.print("Nodi adiacenti al nodo " + node.getValue().val + ": ");
            for (Node node1 : node.getValue().adj)
                System.out.print(node1.val + ", ");
            System.out.println();
        }
    }

    public Node remove(int val){
        if (this.edges.containsKey(val)){
            Node nodeToDelete = this.edges.get(val);
            TreeSet<Node> adjToDelete = nodeToDelete.adj;

            for (Node node : adjToDelete){
                node.removeAdj(nodeToDelete);
            }

            this.edges.remove(val);

            return nodeToDelete;
        }

        throw   new IllegalArgumentException("There is no such element in the data structure.");
    }

    public HashMap<Integer, Node> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Integer, Node> edges) {
        this.edges = edges;
    }
}
