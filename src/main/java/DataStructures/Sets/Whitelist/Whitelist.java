package DataStructures.Sets.Whitelist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Whitelist {
    private Set<String> allowedWords;

    public Whitelist(Set<String> allowedWords){
        this.allowedWords = allowedWords;
    }

    public void printText(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            String curr = scanner.next();
            if (allowedWords.contains(curr))
                System.out.println(curr);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> allowedWords = new HashSet<>();
        allowedWords.add("peppe");
        allowedWords.add("ciao");
        allowedWords.add("apice");
        allowedWords.add("buonasera");

        Whitelist whitelist = new Whitelist(allowedWords);

        File file = new File("src/main/java/DataStructures/Sets/Whitelist/text.txt");
        whitelist.printText(file);
    }
}
