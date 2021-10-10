package DataStructures.PriorityQueue;

public class PQArrayDemo {
    public static void main(String[] args) {
        PriorityQueueArray pq = new PriorityQueueArray(5);
        pq.insert(12);
        pq.insert(7);
        pq.insert(10);
        pq.insert(1);
        pq.insert(8);

        for (int el : pq.getElements())
            System.out.println(el);
    }
}
