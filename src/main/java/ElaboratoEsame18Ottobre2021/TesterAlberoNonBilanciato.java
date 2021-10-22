/**
 * @author giuliano ranauro
 * Date: 22/10/2021 18:55
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package ElaboratoEsame18Ottobre2021;

import java.util.ArrayList;

/**
 * La classe deve inoltre prevedere che un albero sia sbilanciato a sinistra o a destra (in questo caso a sinistra) e deve ritornare
 * che NON rispetta le regole del red-black tree.
 * L'algoritmo in questo caso funziona perchè quando ritorna lo shortest path, ritorna l'arraylist del path più corto tra il destro ed il sinistro,
 * siccome in questo caso abbiamo tutti i nodi a sinistra, il path destro (più piccolo) è proprio zero.
 * */

public class TesterAlberoNonBilanciato {
    public static void main(String[] args) {
        VerificaAlbero.BinaryTree tree = new VerificaAlbero.BinaryTree();

        tree.root = new VerificaAlbero.Node(1);
        tree.root.left = new VerificaAlbero.Node(2);
        tree.root.left.left = new VerificaAlbero.Node(3);
        tree.root.left.left.left = new VerificaAlbero.Node(4);

        VerificaAlbero.Node x = tree.root.right;

        ArrayList<Integer> shortestPath = tree.shortestPath(tree.getRoot());

        ArrayList<Integer> longestPath = tree.longestPath(tree.getRoot());

        System.out.print("Cammino verso la foglia più vicina partendo dalla root: ");
        for (int i = shortestPath.size()-1; i >= 0; i--){
            System.out.print(shortestPath.get(i) + " -> ");
        }
        System.out.print(" nodo foglia. \n");


        System.out.print("Cammino verso la foglia più lontana partendo dalla root: ");
        for (int i = longestPath.size()-1; i >= 0; i--){
            System.out.print(longestPath.get(i) + " -> ");
        }
        System.out.print(" nodo foglia. ");

        // decremento di 1 per non contare la root
        if ((longestPath.size()-1) <= 2 * (shortestPath.size()-1)){
            System.out.println("\nL'albero rispetta la proprietà di bilanciamento");
        }else  System.out.println("\nL'albero NON rispetta la proprietà di bilanciamento");
    }
}
