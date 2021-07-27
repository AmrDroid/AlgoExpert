package AlgoExpert;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static int firstNonRepeating(String string) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i = 0; i < string.length(); i++) {
            if (map.get(string.charAt(i)) == 1) return i;
        }

        return -1;
    }


    public static int firstNonRepeating2(String str) {
        int[] fi = new int [256];

        for(int i = 0; i<256; i++)
            fi[i] = -1;

        for(int i = 0; i<str.length(); i++) {
            if(fi[str.charAt(i)] == -1) {
                fi[str.charAt(i)] = i;
            }else {
                fi[str.charAt(i)] = -2;
            }
        }

        int res =  Integer.MAX_VALUE;

        for(int i = 0; i<256; i++) {
            if(fi[i] >= 0)
                res = Math.min(res, fi[i]);
        }
        if(res ==  Integer.MAX_VALUE) return -1;
        else return res;
    }


    public static void main(String[] args) {
        String text = "GeeksforGeeks";

        System.out.println(text.charAt(firstNonRepeating(text)));
        System.out.println(text.charAt(firstNonRepeating2(text)));
    }

}
