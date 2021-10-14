package Challanges.Esercitazioni.Esercizio7;

import java.util.HashMap;
/**
 * L'obbiettivo è quello di controllare se una parola può essere anagramma dell'altra.
 * Una parola è anagramma di un'altra nel momento in cui l'insieme di lettere ed il relativo count di comparizione è lo stesso.
 * ci basta quindi creare due mappe dove andiamo ad inserire come chiave la lettera e come valore il count di comparizione della lettera.
 * se le due mappe sono uguali allora sono anagrammi.
 *
 * Il tempo di esecuzione richiesto doveva essere minore di O(N^2). In questo caso, usando le mappe, siamo di gran lunga sotto questo tempo.
 * */
public class CheckAnagramma {
    private HashMap<Character, Integer> firstWord;
    private HashMap<Character, Integer> secondWord;

    public CheckAnagramma(){
        firstWord = new HashMap<>();
        secondWord = new HashMap<>();
    }

    public boolean checkWords(String firstWord, String secondWord){
        if (firstWord.length() != secondWord.length())
            return false;   //inutile controllare

        this.readString(firstWord,this.firstWord);
        this.readString(secondWord,this.secondWord);

        if (this.firstWord.equals(this.secondWord))
            return true;
        return false;
    }

    private void readString(String word, HashMap<Character, Integer> map){
        for (int i = 0; i<word.length(); i++){
            if (map.containsKey(word.charAt(i))){
                map.put(word.charAt(i),map.get(word.charAt(i))+1);
            }else map.put(word.charAt(i),1);
        }
    }


    public static void main(String[] args) {
        CheckAnagramma check = new CheckAnagramma();
        System.out.println(check.checkWords("calendario","locandiera"));;
    }
}
