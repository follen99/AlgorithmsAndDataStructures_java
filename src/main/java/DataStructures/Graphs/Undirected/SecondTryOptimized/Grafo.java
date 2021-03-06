/**
 * @author giuliano ranauro
 * Date: 21/10/2021 21:24
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Undirected.SecondTryOptimized;

import java.util.*;
/**
 * Questa classe è una classe usata per modellare un grafo.
 * Un grafo, molto semplicemente, è composto da un insieme di vertici ed un insieme di archi.
 *
 * In questo caso, poco ortodossalmente, il grafo è composto da un'unica struttura dati principale: una mappa che associa
 * ad ogni chiave (il valore del nodo) il suo oggetto Node (che contiene i suoi elementi adiacenti attraverso un TreeSet)
 *
 * Non ho visto questa implementazione da nessuna parte per ora, infatti mi è stato insegnato che i
 * grafi possono essere rappresentati tramite:
 * -    matrice di adiacenza
 * -    lista di adiacenza
 *
 * Non so se questo tipo di rappresentazione sia abbastanza efficiente (date le strutture dati usate credo proprio di si)
 * ma so per certo che ha un difetto sostanziale:
 * per via della struttura dati usata (una mappa) non possiamo inserire nodi duplicati.
 *
 * Sono inoltre sicuro, che potrebbe essere ulteriormente ottimizzato, nelle operazioni sui nodi adiacenti,
 * utilizzando un'ulteriore mappa al posto di un albero per i nodi adiacenti.
 * */
public class Grafo {
    /**
     * C'è da dire una cosa molto importante sulla BFS !!!
     * la BFS è solitamente usata sui grafi direzionati (ma nulla ci vieta di usarla anche su quelli non direzionati)
     * L'idea sarebbe quella di trovare un percorso minimo per ogni nodo, il problema è che nei grafi non direzionati
     * non facciamo differenza tra arco uscente o entrante.
     * */
    public static class BreadthFirstPaths{
        private boolean[] marked;
        private int[] edgeTo;
        private int[] distTo;

        public BreadthFirstPaths(Grafo G, int s){
            this.marked = new boolean[G.size()];
            this.edgeTo = new int[G.size()];
            this.distTo = new int[G.size()];

            bfs(G, s);
        }

        private void bfs(Grafo G, int s){
            Queue<Integer> q = new ArrayDeque<>();
            q.add(s);
            marked[s] = true;
            distTo[s] = 0;

            while(!q.isEmpty()){
                int v = q.remove();
                for(Node w : G.adj(v)){
                    if(!marked[w.val]){
                        q.add(w.val);
                        marked[w.val] = true;
                        edgeTo[w.val] = v;
                        distTo[w.val] = distTo[v] + 1;
                    }
                }
            }
        }

        public void printPath(){
            for (int i = 0; i < marked.length; i++){
                if (marked[i]){
                    System.out.print(i + " -> ");
                    printPath(i);
                    System.out.println();
                }
            }
        }
        private void printPath(int element){
            if (this.edgeTo[element] == 0) {
                System.out.print(0);
                return;
            }
            System.out.print(this.edgeTo[element]+" -> ");
            printPath(this.edgeTo[element]);
        }


        public boolean[] getMarked() {
            return marked;
        }

        public int[] getEdgeTo() {
            return edgeTo;
        }

        public int[] getDistTo() {
            return distTo;
        }
    }

    public static class DepthFirstPaths{
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public DepthFirstPaths(Grafo grafo, int s){
            marked = new boolean[grafo.size()+1];
            edgeTo = new int[grafo.size()+1];
            dfs(grafo,s);
        }


        public int[] getEdgeTo() {
            return edgeTo;
        }

        public boolean[] getMarked() {
            return marked;
        }


        private void dfs(Grafo G, int v){
            marked[v] = true;
            for(Node w : G.adj(v))
                if(!marked[w.val]){		// se un vertice non è stato visitato chiama ricorisvamente se stessa su quel vertice
                    dfs(G, w.val);
                    edgeTo[w.val] = v;
                }
        }

        public void printPath(){
            for (int i = 0; i < marked.length; i++){
                if (marked[i]){
                    System.out.print(i + " -> ");
                    printPath(i);
                    System.out.println();
                }
            }
        }

        private void printPath(int element){
            if (this.edgeTo[element] == 0) {
                System.out.print(0);
                return;
            }
            System.out.print(this.edgeTo[element]+" -> ");
            printPath(this.edgeTo[element]);
        }
    }

    /** METODI USATI PER LA DFS */
    public TreeSet<Node> adj(int v) {
        return this.edges.get(v).getAdj();
    }
    public int size(){
        return this.edges.size();
    }
    /** METODI USATI PER LA DFS */

    public class Node implements Comparator<Node>, Comparable<Node> {
        private TreeSet<Node> adj;
        private int val;


        /**
         * il rank ci dice quanti elementi adiacenti ha il nodo
         * in questo caso teniamo il conto in una variabile (usando spazio) per avere delle performance
         * migliori quando verrà chiamato il rank. Possiamo anche non tenere il conto ed effettuare il count ogni volta
         *
         * anzi, effettivamente è meglio non tenere il conto ma calcolarci il valore ogni volta,
         * visto che la funzione rank potrebbe non essere usata così tanto spesso.
         *
         * ad ogni modo dipende dal tipo di applicazione
         * */
        // private long rank;

        public Node(int value){
            this.adj = new TreeSet<>();
            this.val = value;
        }
        public Node(int value, Node adj){
            this.adj = new TreeSet<>();
            this.adj.add(adj);

            this.val = value;
        }

        public TreeSet<Node> getAdj() {
            return adj;
        }

        public void addAdj(Node adj){
            this.adj.add(adj);
        }

        public void removeAdj(Node adj){
            this.adj.remove(adj);
        }

        public long rank(){
            return (long)this.adj.size();
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
    public Node remove(Node nodeToDelete){
        if (this.edges.containsValue(nodeToDelete)){
            TreeSet<Node> adjToDelete = nodeToDelete.adj;

            for (Node node : adjToDelete){
                node.removeAdj(nodeToDelete);
            }

            this.edges.remove(nodeToDelete.val);

            return nodeToDelete;
        }

        throw   new IllegalArgumentException("There is no such element in the data structure.");
    }

    public boolean adjTo(int v, int w){
        if (this.edges.containsKey(v)){
            if (this.edges.get(v).adj.contains(this.edges.get(w)))
                return true;
        }
        return false;
    }
    public boolean adjTo(Node v, Node w){
        if (this.edges.containsValue(v)){
            if (v.adj.contains(w))
                return true;
        }
        return false;
    }

    public long rank(int edgeKey){
        // ritorno il calcolo fatto con il metodo rank della classe nodo (che conta gli elementi nel set dei nodi adiacenti)
        return this.edges.get(edgeKey).rank();
    }

    /**@Todo*/
    public ArrayList<Node> shortestPath(int v, int w){

        return null;
    }

    public long rank(Node edge){
        return edge.rank();
    }

    public HashMap<Integer, Node> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Integer, Node> edges) {
        this.edges = edges;
    }
}
