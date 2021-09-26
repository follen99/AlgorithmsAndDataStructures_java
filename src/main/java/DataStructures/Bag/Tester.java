/**
 * @author giuliano ranauro
 * Date: 26/09/2021 20:33
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.Bag;

import java.util.Iterator;

public class Tester {
    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.add("ciao");
        bag.add("come");
        bag.add("va");
        bag.add("oggi");

        for (String s : bag){
            System.out.println(s);
        }
    }

}
