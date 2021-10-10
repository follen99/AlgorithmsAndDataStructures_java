/**
 * @author giuliano ranauro
 * Date: 09/10/2021 16:21
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */

package DataStructures.PriorityQueue;
import java.util.*;
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        pq.add(5);
        pq.add(3);
        pq.add(20);
        pq.add(30);
        pq.add(100);
        pq.add(19);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
