package Challanges.Esercitazioni.Esercizio6;

public class SearchPalindroma {
    public static boolean checkPalindroma(String string){
        int len = string.length()-1;

        for (int i = 0; i < string.length()-1; i++){
            if (!(string.charAt(i) == string.charAt(len)))
                return false;
            len--;
        }

        return true;
    }

    public static boolean checkPalindromaRecursive(String stringToCheck){
        if (stringToCheck.length() < 2)
            return true;    // le stringhe di lunghezza 1 sono palindrome
        if (stringToCheck.charAt(0) == stringToCheck.charAt(stringToCheck.length()-1))
            return checkPalindromaRecursive(stringToCheck.substring(1,stringToCheck.length()-1));

        return false;
    }

    public static void main(String[] args) {
        String test = "gattoneroorenottag";
        System.out.println(SearchPalindroma.checkPalindroma(test));

        System.out.println(SearchPalindroma.checkPalindromaRecursive(test));
    }
}
