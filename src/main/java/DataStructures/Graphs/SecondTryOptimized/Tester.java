/**
 * @author giuliano ranauro
 * Date: 21/10/2021 21:24
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Graphs.SecondTryOptimized;

import java.util.HashMap;

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


        grafo.remove(1);
        System.out.println("\nDeleted node 1\n");


        grafo.printAll();
    }
}
