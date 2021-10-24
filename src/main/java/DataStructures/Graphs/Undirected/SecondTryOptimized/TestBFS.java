/**
 * @author giuliano ranauro
 * Date: 23/10/2021 20:22
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Undirected.SecondTryOptimized;

public class TestBFS {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        /*
        grafo.add(0,2);
        grafo.add(0,1);
        grafo.add(0,5);
        grafo.add(2,4);
        grafo.add(2,3);
        grafo.add(4,3);
        grafo.add(3,5);
        */

        grafo.add(0,1);
        grafo.add(0,2);
        grafo.add(0,6);

        grafo.add(0,5);
        grafo.add(5,3);
        grafo.add(5,4);
        grafo.add(3,4);
        grafo.add(4,6);

        grafo.add(7,8);

        grafo.add(9,10);
        grafo.add(9,12);
        grafo.add(9,11);
        grafo.add(11,12);

        grafo.printAll();

        int rootNode = 0;

        Grafo.BreadthFirstPaths dfp = new Grafo.BreadthFirstPaths(grafo, rootNode);
        boolean[] marked = dfp.getMarked();
        int[] edgeTo = dfp.getEdgeTo();
        /*for (boolean mark : marked){
            System.out.println(mark);
        }*/

        System.out.println("Nodi connessi al nodo " + rootNode + "\n");
        for (int i = 0; i < grafo.size(); i++){
            if (marked[i]){
                System.out.print(i + ", ");
            }
        }

        System.out.println("Ogni nodo è connesso a " + rootNode + " in questo modo: ");
        dfp.printPath();
    }
}
