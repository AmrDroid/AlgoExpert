package AlgoExpert.Easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        if (document.equals("")) return true;

        Map<Character, Integer> availableChars = new HashMap<>();

        for (char c : characters.toCharArray())
            availableChars.put(c, availableChars.getOrDefault(c, 0) + 1);

        for (char c : document.toCharArray()) {
            if (!availableChars.containsKey(c) || availableChars.get(c) <= 0) return false;

            availableChars.put(c, availableChars.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String charchters = "ABCDEABCD";
        String doc = "ABCDEABDD";

        System.out.println(generateDocument(charchters,doc));
    }

}
