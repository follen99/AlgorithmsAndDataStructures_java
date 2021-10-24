/**
 * @author giuliano ranauro
 * Date: 24/10/2021 12:15
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Directed;

public class Tester {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.add(0,2);
        grafo.add(0,1);
        grafo.add(1,2);
        grafo.add(2,4);
        grafo.add(3,2);
        grafo.add(3,5);
        grafo.add(4,3);
        grafo.add(5,0);

        grafo.printAll();

        int rootNode = 0;

        Grafo.BreadthFirstPaths bfs = new Grafo.BreadthFirstPaths(grafo, rootNode);
        boolean[] marked = bfs.getMarked();
        int[] edgeTo = bfs.getEdgeTo();
        /*for (boolean mark : marked){
            System.out.println(mark);
        }*/

        System.out.print("Nodi connessi al nodo " + rootNode + ":");
        for (int i = 0; i < grafo.size(); i++){
            if (marked[i]){
                System.out.print(i + ", ");
            }
        }

        System.out.println("\nShortest path da " + rootNode + ": ");
        bfs.printPath();
    }
}
