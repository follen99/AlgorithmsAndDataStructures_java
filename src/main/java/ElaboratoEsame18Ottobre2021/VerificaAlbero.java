/**
 * @author giuliano ranauro
 * Date: 22/10/2021 18:45
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package ElaboratoEsame18Ottobre2021;

import java.util.ArrayList;

/**
 * Implementare un algoritmo che, ricevuto in ingresso un albero binario, determina se esso soddisfa o meno
 * la proprietà di bilanciamento dell'altezza dell'albero rosso-nero. La proprietà di bilanciamento
 * dell'altezza dell'albero rosso-nero afferma che il percorso dalla radice alla foglia più lontana non è più lungo
 * del doppio del percorso dalla radice alla foglia più vicina. L'algoritmo deve avere una complessità temporale di O(n)
 * */

/**
 * Questo problema poteva essere svolto in modi molto migliori rispetto a questo, ne sono consapevole.
 * Ad ogni modo durante gli esami non si riesce mai a ragionare completamente in modo lucido, ma se non altro, funziona :)
 * */
public class VerificaAlbero {
    static class Node
    {
        int key;
        Node left, right;

        public Node(int key)
        {
            this.key = key;
            left = right = null;
        }
    }


    static class BinaryTree
    {
        static Node root;

        public Node getRoot(){
            return this.root;
        }

        public static ArrayList<Integer> shortestPath(){
            return calcPath(root, false);
        }
        public static ArrayList<Integer> longestPath(){
            return calcPath(root, true);
        }


        private static ArrayList<Integer> calcPath(Node root, boolean shortestLongest)
        {


            //se la root è nulla vuol dire che non c'è un albero
            if(root == null)
            {
                ArrayList<Integer> output = new ArrayList<>();
                return output;
            }

            // chiamata ricorsiva sull'albero destro
            ArrayList<Integer> right = calcPath(root.right, shortestLongest);

            // chiamata ricorsiva sull'albero sinistro
            ArrayList<Integer> left = calcPath(root.left, shortestLongest);


            // confronto la grandezza dei due arraylist
            // inserisco il nodo corrente
            if (shortestLongest){
                if(right.size() < left.size())
                {
                    left.add(root.key);
                }
                else
                {
                    right.add(root.key);
                }
            }else {
                if(right.size() > left.size())
                {
                    left.add(root.key);
                }
                else
                {
                    right.add(root.key);
                }
            }

            // ritorno l'arraylist appropriato
            if (shortestLongest)
                return (left.size() >
                        right.size() ? left :right);
            else return (left.size() >
                    right.size() ? left :right);
        }



        /*
        public static ArrayList<Integer> longestPath(Node root)
        {


             //se la root è nulla vuol dire che non c'è un albero
            if(root == null)
            {
                ArrayList<Integer> output = new ArrayList<>();
                return output;
            }

            // chiamata ricorsiva sull'albero destro
            ArrayList<Integer> right = longestPath(root.right);

            // chiamata ricorsiva sull'albero sinistro
            ArrayList<Integer> left = longestPath(root.left);


             // confronto la grandezza dei due arraylist
             // inserisco il nodo corrente
            if(right.size() < left.size())
            {
                left.add(root.key);
            }
            else
            {
                right.add(root.key);
            }

            // ritorno l'arraylist appropriato
            return (left.size() >
                    right.size() ? left :right);
        }
        */
        /*
        public static ArrayList<Integer> shortestPath(Node root)
        {


             //se la root è nulla vuol dire che non c'è un albero
            if(root == null)
            {
                ArrayList<Integer> output = new ArrayList<>();
                return output;
            }

            // chiamata ricorsiva sull'albero destro
            ArrayList<Integer> right = longestPath(root.right);

            // chiamata ricorsiva sull'albero sinistro
            ArrayList<Integer> left = longestPath(root.left);


             // confronto la grandezza dei due arraylist
             // inserisco il nodo corrente
            if(right.size() > left.size())
            {
                left.add(root.key);
            }
            else
            {
                right.add(root.key);
            }

            // ritorno l'arraylist appropriato
            return (left.size() <
                    right.size() ? left :right);
        }*/
    }
}
