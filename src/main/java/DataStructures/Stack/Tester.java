/**
 * @author giuliano ranauro
 * Date: 25/09/2021 16:39
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Stack;

public class Tester {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Stack insert:");
        for (int i = 0; i<5; i++) {
            stack.push(i);
            System.out.println(i);
        }

        System.out.println("popping elements:");


        for (int i = 0; i<5; i++) {
            System.out.println(stack.pop());
        }
    }
}
