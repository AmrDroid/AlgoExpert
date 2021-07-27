package AlgoExpert;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i = 0; i < string.length(); i++) {
            if (map.get(string.charAt(i)) == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "GeeksforGeeks";

        System.out.println(text.charAt(firstNonRepeatingCharacter(text)));
    }

}