package Challanges.Esercitazioni.Esercizio3;

import java.util.*;

public class FindTimes {
    public static boolean find(int[] arr){
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int el : arr){
            if (!counts.containsKey(el)){
                counts.put(el,1);
            }else {
                int count = counts.get(el);
                counts.put(el, count + 1);
            }
        }
        return findDuplicates(counts.values().toArray(new Integer[counts.values().size()]));
    }

    private static boolean findDuplicates(Integer[] values){
        Set<Integer> vals = new HashSet<>();

        for (int i = 0; i<values.length; i++){
            if (vals.contains(values[i]))
                return true;
            else vals.add(values[i]);
        }

        return false;
    }




}
