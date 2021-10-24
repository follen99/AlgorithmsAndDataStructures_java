/**
 * @author giuliano ranauro
 * Date: 24/10/2021 11:58
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Directed;

import java.util.*;

public class Grafo {
    public HashMap<Integer, Node> edges;
    public Grafo(){
        this.edges = new HashMap<>();
    }
    private class Node implements Comparator<Node>, Comparable<Node> {
        private Set<Node> adj;
        private int val;

        public Node(int val){
            this.adj = new HashSet<>();
            this.val = val;
        }

        public Node(int val, Node adj){
            this.adj = new HashSet<>();
            this.adj.add(adj);

            this.val = val;
        }

        public void addAdj(Node adj){
            this.adj.add(adj);
        }

        public void removeAdj(Node adj){
            if (this.adj.contains(adj))
                this.adj.remove(adj);
        }

        public Set<Node> getAdj() {
            return adj;
        }

        public void setAdj(Set<Node> adj) {
            this.adj = adj;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val > o.val)
                return 1;
            else if (this.val < o.val)
                return -1;
            return 0;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.val > o2.val)
                return 1;
            else if (o1.val < o2.val)
                return -1;
            return 0;
        }
    }



    /**
     * Devo aggiungere il secondo nodo al prima, ma non viceversa
     * */
    public void add(int edge1, int edge2){
        Node node1 = null;
        Node node2 = null;

        if (this.edges.containsKey(edge1))
            node1 = this.edges.get(edge1);
        if (this.edges.containsKey(edge2))
            node2 = this.edges.get(edge2);

        if (node1 != null){
            if (node2 != null){
                // caso in cui sono presenti entrambi i nodi
                node1.addAdj(node2);
                // in un grafo direzionato qui avrei aggiungo il nodo 1 al nodo 2
            }else {
                // caso in cui il primo nodo è presente ma il 2 no
                node2 = new Node(edge2);
                node1.addAdj(node2);
                // in un grafo direzionato qui avrei aggiungo il nodo 1 al nodo 2

                edges.put(node2.val, node2);
            }
        }else{
            if (node2 != null){
                // caso in cui il primo nodo non è presente ma il 2 si
                node1 = new Node(edge1, node2);

                edges.put(node1.val, node1);
            }else{
                node1 = new Node(edge1);
                node2 = new Node(edge2);

                node1.addAdj(node2);

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
}
