/**
 * @author giuliano ranauro
 * Date: 21/10/2021 21:18
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.Undirected.SecondTrySimple;

public class Tester {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.add(1,2);
        grafo.add(1,3);
        grafo.add(1,4);
        grafo.add(1,5);
        grafo.add(3,4);
        grafo.add(3,5);

        grafo.printAll();
    }
}
