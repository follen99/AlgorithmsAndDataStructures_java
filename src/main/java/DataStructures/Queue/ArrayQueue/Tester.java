/**
 * @author giuliano ranauro
 * Date: 25/09/2021 17:26
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Queue.ArrayQueue;

public class Tester {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("Ciao");
        queue.enqueue("come");
        queue.enqueue("va");
        queue.enqueue("oggi");


        System.out.println("All elements");
        for (String str : queue.getArray())
            System.out.println(str);

        System.out.println("Deleting one element per time");
        for (int i = 0; i < 4 ; i++)
            System.out.println(queue.dequeue());
    }
}
