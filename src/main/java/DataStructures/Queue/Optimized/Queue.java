/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:49
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.Optimized;

public class Queue {
    private Node first, last;

    public boolean isEmpty(){
        return first == null;           //se è presente almeno un nodo non è vuota
    }

    public  void enqueue(String item){
        Node oldLast = this.last;       //salvo l'ultimo nodo
        last = new Node();
        last.setValue(item);
        last.setNext(null);             //in questo caso il nodo è l'ultimo e non ha un successivo

        if (this.isEmpty()) first = last;   // se la struttura è vuota inseriamo al primo posto (ed unico)
        else oldLast.setNext(last);
    }

    public String dequeue(){
        String element = this.first.getValue(); //salvo il valore del primo, che verrà eliminato.

        this.first = first.getNext();
        if (this.isEmpty()) last = null;
        return element;

    }
}
