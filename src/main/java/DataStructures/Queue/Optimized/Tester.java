/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:57
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.Optimized;

public class Tester {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("ciao");
        queue.enqueue("come");
        queue.enqueue("va");
        queue.enqueue("oggi?");


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
