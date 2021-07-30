package AlgoExpert.Medium;

import java.util.ArrayList;
import java.util.List;

public class MonotonicArray {

    public static boolean isMonotonic2(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 2) return true;

        boolean isIncreasing = true, isDecreasing = true;

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) isIncreasing = false;
            else if (numbers.get(i) < numbers.get(i + 1)) isDecreasing = false;
        }

        return isIncreasing || isDecreasing;
    }


    private static boolean isMonotonic(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 2) return true;

        boolean increasing = false;
        if (numbers.get(0) < numbers.get(1))
            increasing = true;
        if (numbers.get(0) == numbers.get(1) && numbers.get(1) < numbers.get(2))
            increasing = true;

        for (int i = 2; i < numbers.size(); i++) {
            if (increasing && numbers.get(i) < numbers.get(i - 1))
                return false;
            else if (!increasing && numbers.get(i) > numbers.get(i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(2);
        A.add(4);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);

        System.out.println(isMonotonic(A));
        System.out.println(isMonotonic2(A));

    }

}
