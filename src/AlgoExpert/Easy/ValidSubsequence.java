package AlgoExpert.Easy;

import java.util.HashMap;
import java.util.List;

public class ValidSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int m=array.size();
        int n=sequence.size();
        HashMap<Integer, Integer> frequency = new HashMap<Integer,Integer>();

        for(int i = 0; i < m; i++)
        {
            frequency.put(array.get(i), frequency.getOrDefault(array.get(i), 0) + 1);
        }

        for(int i = 0; i < n; i++)
        {
            if (frequency.getOrDefault(sequence.get(i), 0) > 0)
                frequency.put(sequence.get(i), frequency.get(array.get(i)) - 1);
            else
            {
                return false;
            }
        }
        return true;

    }
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {

        int seqIdx = 0;
        for (int value : array) {
            if (value == sequence.get(seqIdx)) seqIdx++;
            if (seqIdx == sequence.size()) return true;
        }
        return false;
    }
    public static boolean isValidSubsequence3(List<Integer> array, List<Integer> sequence) {

        int arrIdx = 0;
        int seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx) == sequence.get(seqIdx)) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }



}
