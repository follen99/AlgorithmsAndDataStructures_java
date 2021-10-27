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
        PriorityQueueArray pq = new PriorityQueueArray(6);

        /*pq.insert(5);
        pq.insert(3);
        pq.insert(20);
        pq.insert(30);
        pq.insert(100);
        pq.insert(19);*/

        pq.insert(100);
        pq.insert(78);
        pq.insert(98);
        pq.insert(68);
        pq.insert(58);
        pq.insert(1);

        int[] elements = pq.getElements();

        for (int i : elements){
            System.out.print(i + "\t");
        }
        System.out.println();


        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
}
