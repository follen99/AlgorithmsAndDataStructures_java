/**
 * @author giuliano ranauro
 * Date: 21/10/2021 20:58
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.FirstTry;

public class Tester {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.add(1,2);
        grafo.add(3,4);
        grafo.add(2,4);

        grafo.printAll();
    }
}
