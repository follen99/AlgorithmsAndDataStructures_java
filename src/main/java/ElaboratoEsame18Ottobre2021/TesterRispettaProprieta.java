/**
 * @author giuliano ranauro
 * Date: 22/10/2021 18:48
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package ElaboratoEsame18Ottobre2021;

import java.util.ArrayList;

/**
 * Questo esempio riporta un albero che rispetta la proprietà di bilanciamento,
 * in quanto la foglia più vicina è (4), posta a 3 nodi dalla root.
 * la foglia più lontana è (10) o (9), poste a 5 nodi dalla root.
 *
 * siccome 4 <= 2 * 2 rispetta le proprietà.
 * */
public class TesterRispettaProprieta {
    public static void main(String[] args)
    {
        VerificaAlbero.BinaryTree tree = new VerificaAlbero.BinaryTree();

        tree.root = new VerificaAlbero.Node(1);
        tree.root.left = new VerificaAlbero.Node(2);
        tree.root.left.left = new VerificaAlbero.Node(4);

        tree.root.right = new VerificaAlbero.Node(3);
        tree.root.right.left = new VerificaAlbero.Node(5);
        tree.root.right.right = new VerificaAlbero.Node(6);

        tree.root.right.left.left = new VerificaAlbero.Node(7);
        tree.root.right.left.right = new VerificaAlbero.Node(8);


        tree.root.right.left.left.left = new VerificaAlbero.Node(9);
        tree.root.right.left.left.right = new VerificaAlbero.Node(10);



        VerificaAlbero.Node x = tree.root.right;

        ArrayList<Integer> shortestPath = tree.shortestPath();
        ArrayList<Integer> longestPath = tree.longestPath();

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

        if ((longestPath.size()-1) <= 2 * (shortestPath.size()-1)){
            System.out.println("\nL'albero rispetta la proprietà di bilanciamento");
        }else  System.out.println("\nL'albero NON rispetta la proprietà di bilanciamento");
    }
}
