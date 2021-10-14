package Challanges.Esercitazioni.Esercizio5;
/**
 * la challange è di scambiare due interi senza usare variabili temporanee*/
public class SwapIntegers {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println("A: "+ a + " B: " + b);

        a = a + b;      // a = 8, b = 3
        b = a - b;      // a = 8, b = 5

        a = a - b;      // a = 3, b = 5

        System.out.println("A: "+ a + " B: " + b);


    }

}
