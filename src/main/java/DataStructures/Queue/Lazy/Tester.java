/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:44
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.Lazy;

public class Tester {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
