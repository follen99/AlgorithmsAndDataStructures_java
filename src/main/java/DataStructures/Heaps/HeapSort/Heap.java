/**
 * @author giuliano ranauro
 * Date: 08/10/2021 16:31
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Heaps.HeapSort;

/**
 * Video esempio: https://www.youtube.com/watch?v=t0Cq6tVNRBA
 * HEAP:
 * un heap è una struttura simile ad un BST, ma con la differenza
 * che il primo elemento, la radice, è l'elemento più piccolo della struttura.
 *
 * Cosa succede se inseriamo un elemento che non rispetta l'ordine dell'heap?
 * possiamo inserire l'elemento in ultima posizione, e se non rispetta l'ordine,
 * lo facciamo "risalire" verso l'alto, finchè esso non rispetta l'ordine.
 *
 * Come rimuoviamo l'elemento più piccolo?
 * per rimuovere il primo elemento, lo scambiamo con l'ultimo elemento utile, dopodichè
 * lo facciamo scendere (bubble down) fino alla posizione corretta che rispetto l'ordine
 * dell'heap.
 *
 * Per risparmiare spazio possiamo usare un array per risparmiare spazio seguendo le semplici equazioni:
 * parent = (index-2)/2
 * left = index*2 +1
 * right = index*2 +2
 * */
public class Heap {

    public Heap(){}

    public void sort(Comparable[] pq){
        int n = pq.length;

        for (int k = n/2; k>= 1; k--){
            sink(pq, k, n);
        }

        int k = n;
        while (k > 1){
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    //metodo usato per stampare gli elementi dell'array.
    public void show(Comparable[] a){
        for (int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    private void sink(Comparable[] pq, int k, int n){
        while (2*k < n){
            int j = 2*k;
            if(j < n && less(pq, j, j+1))
                j++;
            if(!less(pq, k ,j))
                break;
            exch(pq, k, j);
            k = j;
        }
    }

    private void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private boolean less(Comparable[] pq, int j, int i) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
}
