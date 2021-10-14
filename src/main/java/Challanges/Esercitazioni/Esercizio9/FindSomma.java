package Challanges.Esercitazioni.Esercizio9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSomma {
    private Map<Integer, Integer> map;
    private Set<Integer> set;

    public FindSomma(){
        this.map = new HashMap<>();
        this.set = new HashSet<>();
    }

    /**
     * Questo metodo, con le mappe, ci serve solo se vogliamo sapere QUALI elementi hanno prodotto la somma.
     * Se vogliamo sapere solo se la somma esiste possiamo usare altre strutture dati, come il SET
     * */
    public boolean findSommaMap(int[] arr, int toFind){
        for (int i = 0; i < arr.length; i++){
            if (this.map.containsKey(toFind - arr[i])) {
                System.out.println("la somma degli elementi " + (toFind - arr[i]) + " + " + arr[i] + " e' uguale a " + toFind);
                return true;
            }
            map.put(arr[i],i);
        }
        return false;
    }

    public boolean findSommaSet(int[] arr, int toFind){
        for (int i = 0; i < arr.length; i++){
            if (this.set.contains(toFind - arr[i]))
                return true;
            this.set.add(arr[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        FindSomma find = new FindSomma();
        int[] arr = {2,5,1,8,6,0};
        int x = 1;

        System.out.println(find.findSommaMap(arr,x));
        System.out.println(find.findSommaSet(arr,x));
    }
}
