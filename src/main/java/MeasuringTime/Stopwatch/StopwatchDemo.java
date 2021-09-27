/**
 * @author giuliano ranauro
 * Date: 26/09/2021 20:48
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package MeasuringTime.Stopwatch;

import DataStructures.LinkedList.LinkedList;

public class StopwatchDemo {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        LinkedList list = new LinkedList();
        for (int i = 0; i<10000000 ; i++)
            list.insertHead(i);

        System.out.println("Elapsed time to create list and insert: "+stopwatch.elapsedTime());

        stopwatch = new Stopwatch();

        while (list.hasNext())
            //System.out.println(list.removeHead());
            list.removeHead();

        System.out.println("Elapsed time to pop the elements: "+stopwatch.elapsedTime());


    }

}
