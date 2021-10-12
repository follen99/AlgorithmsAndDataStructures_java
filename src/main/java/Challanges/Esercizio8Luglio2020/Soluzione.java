/**
 * @author giuliano ranauro
 * Date: 12/10/2021 12:45
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package Challanges.Esercizio8Luglio2020;

import java.util.Stack;

public class Soluzione {
    public static void main(String[] args) {
        Stack<Integer> tet = new Stack<>();
        tet.push(3);
        tet.push(2);
        tet.push(1);

        /*for (int i = 0; i<tet.size(); i++)
            System.out.println(tet.pop());*/
        for (int el : tet)
            System.out.println(el);

        System.out.println(tet.pop());
    }

    public static class FIFO{
        private static Stack<Integer> main;
        private static Stack<Integer> swap;

        public FIFO(){
            main = new Stack<>();
            swap = new Stack<>();
        }

        public void enqueue(int val){
            if (main.size()==0)
                main.push(val);
            int n = main.size();
            for (int i = 0; i<n+1; i++){
                swap.push(main.pop());
            }


        }
    }
}
