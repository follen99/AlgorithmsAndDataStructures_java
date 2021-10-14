package DataStructures.Sets.Blacklist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Questa blacklist blocca tutte le parole offensive
 * */
public class Blacklist {
    private Set<String> forbiddenWords;

    public Blacklist(Set<String> forbiddenWords){
        this.forbiddenWords = forbiddenWords;
    }

    public void printText(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String curr = scanner.next();
            if (forbiddenWords.contains(curr)) {
                System.out.print(curr.substring(0, 1));

                for (int i = 1; i < curr.length() - 1; i++)
                    System.out.print("*");

                System.out.print(curr.substring(curr.length() - 1, curr.length()) + " ");

            }

            else {
                System.out.print(curr + " ");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> forbiddenWords = new HashSet<>();
        //parolacce
        forbiddenWords.add("incazzato");
        forbiddenWords.add("porca");
        forbiddenWords.add("puttana");
        forbiddenWords.add("stronzo");

        Blacklist list = new Blacklist(forbiddenWords);
        File file = new File("src/main/java/DataStructures/Sets/Blacklist/text.txt");
        list.printText(file);

    }
}
