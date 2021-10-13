/**
 * @author giuliano ranauro
 * Date: 12/10/2021 12:45
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Challanges.Esami.Esercizio8Luglio2020;

import java.util.Stack;

/**
 * TRACCIA:
 * Creare una struttura dati di tipo FIFO (queue) utilizzando solo strutture di tipo LIFO (stack)
 * Almeno una tra le funzioni di inserimento e rimozione deve essere a tempo di completamento lineare.
 * */

public class Soluzione {
    public static void main(String[] args) throws Exception {
        FIFO fifo = new FIFO();
        fifo.enqueue(3);
        fifo.enqueue(2);
        fifo.enqueue(5);

        System.out.println(fifo.dequeue());
        System.out.println(fifo.dequeue());
    }

    public static class FIFO{
        private static Stack<Integer> main;
        private static Stack<Integer> swap;

        public FIFO(){
            main = new Stack<>();
            swap = new Stack<>();
        }

        public void enqueue(int val){
            if (main.size()==0) {
                main.push(val);
                return;
            }
            int n = main.size();
            for (int i = 0; i<n; i++){
                swap.push(main.pop());
            }

            main.push(val);

            for (int i = 1; i < n+1; i++){
                main.push(swap.pop());
            }
        }

        public int dequeue() throws Exception {
            if (this.main.size() == 0)
                throw new Exception();
            return this.main.pop();
        }

    }
}
