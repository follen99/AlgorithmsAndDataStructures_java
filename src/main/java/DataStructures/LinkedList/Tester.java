/**
 * @author giuliano ranauro
 * Date: 20/09/2021 23:23
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.LinkedList;

public class Tester {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertEnd(3);
        list.insertEnd(2);
        list.insertEnd(4);

        list.printList();
        
        System.out.println("\n\n");
        
        list.removeHead();
        list.printList();
    }
}
