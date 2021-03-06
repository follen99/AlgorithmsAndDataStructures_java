/**
 * @author giuliano ranauro
 * Date: 21/10/2021 21:05
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Undirected.SecondTrySimple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
    public class Node{
        private Set<Node> adj;
        private int val;

        public Node(int value){
            this.adj = new HashSet<>();
            this.val = value;
        }
        public Node(int value, Node adj){
            this.adj = new HashSet<>();
            this.adj.add(adj);

            this.val = value;
        }

        public void addAdj(Node adj){
            this.adj.add(adj);
        }
    }

    private ArrayList<Node> edges;

    public Grafo(){
        this.edges = new ArrayList<>();
    }

    public void add(int edge1, int edge2){
        Node node1 = null;
        Node node2 = null;
        for (Node node : edges){
            if (node.val == edge1)
                node1 = node;
            if (node.val == edge2)
                node2 = node;
        }

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

                edges.add(node2);
            }
        }else {
            // se il nodo 1 non è presente
            if (node2 != null){
                // se il nodo 1 è presente
                node1 = new Node(edge1, node2);
                node2.addAdj(node1);

                edges.add(node1);
            }else{
                // se nemmeno il node 2 è presente
                node1 = new Node(edge1);
                node2 = new Node(edge2);

                node1.addAdj(node2);
                node2.addAdj(node1);

                edges.add(node1);
                edges.add(node2);
            }
        }
    }

    public void printAll(){
        for (Node node : edges){
            System.out.print("Nodi adiacenti al nodo " + node.val + ": ");
            for (Node node1 : node.adj)
                System.out.print(node1.val + ", ");
            System.out.println();
        }
    }
}
