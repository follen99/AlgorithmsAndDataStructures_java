/**
 * @author giuliano ranauro
 * Date: 21/10/2021 20:19
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.FirstTry;

import java.util.ArrayList;

public class Grafo {
    public class Node{
        private ArrayList<Node> adj;
        private int value;

        public Node(int value, int adj) {
            this.adj = new ArrayList<>();

            Node adjNode =  new Node(adj,this);
            this.adj.add(adjNode);
            this.value = value;

            //nodes.add(adjNode);
        }
        public Node(int value, Node adj){
            this.adj = new ArrayList<>();
            this.adj.add(adj);
            this.value = value;
        }

        public Node(int value){
            this.adj = new ArrayList<>();
            this.value = value;
        }


    }
    private ArrayList<Node> nodes;

    public Grafo(){
        nodes = new ArrayList<>();
    }

    public void add(int edge1, int edje2){
        if (!nodes.contains(edge1)){
            if (!nodes.contains(edje2)){
                nodes.add(new Node(edge1,edje2));
            }else {
                Node node2 = null;
                for (Node node : nodes){
                    if (node.value == edje2)
                        node2 = node;
                }

                assert node2 != null;
                nodes.add(new Node(edge1,node2));
            }
        }else {
            Node node1 = null;
            for (Node node : nodes){
                if (node.value == edge1)
                    node1 = node;
            }
            if (!nodes.contains(edje2)){
                node1.adj.add(new Node(edje2,node1));
            }else {
                Node node2 = null;
                for (Node node : nodes){
                    if (node.value == edje2)
                        node2 = node;
                }
                node1.adj.add(node2);
            }
        }
    }

    public void printAll(){
        for (Node node : nodes){
            System.out.print("Nodi adiacenti al nodo: " + node.value + ": ");
            for (Node node1 : node.adj)
                System.out.print(node1.value + "\t");
            System.out.println();
        }
    }

}
