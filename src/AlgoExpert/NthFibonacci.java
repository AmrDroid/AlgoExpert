package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NthFibonacci {

    public static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }


    public static int fibonacci2(int i, HashMap<Integer, Integer> map) {
        if (i == 0) return 0;
        if (i == 1) return 1;

        if (map.containsKey(i)) return map.get(i);

        map.put(i, fibonacci2(i - 1, map) + fibonacci2(i - 2, map));

        return map.get(i);
    }

    public static int fibonacci_2(int i) {
        return fibonacci2(i, new HashMap<>());
    }


    public static int fibonacci3(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }


    public static int fibonacci4(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;

        }
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(10));
        System.out.println(fibonacci_2(10));
        System.out.println(fibonacci3(10));
        System.out.println(fibonacci4(10));
    }


}
