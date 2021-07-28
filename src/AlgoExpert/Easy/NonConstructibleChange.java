package AlgoExpert.Easy;

import java.util.Arrays;

public class NonConstructibleChange {


    //O(m * n) time | O(1) space, where n is the number of coins and m is the sum that all of the coins add up to.
    static int non_constructible_change(int[] coins) {
        if (coins.length == 0 || coins == null)
            return 1;

        Arrays.sort(coins);
        int maxChange = Arrays.stream(coins).sum();
        for (int sum = 1; sum <= maxChange; sum++) {

            int currentSum = sum;
            for (int value = coins.length - 1; value >= 0; value--) {
                int currentValue = coins[value];
                if (currentValue <= currentSum) {
                    currentSum -= currentValue;
                }
                if (currentSum == 0)
                    break;
            }

            if (currentSum > 0)
                return sum;
        }
        return maxChange + 1;
    }

    //O(nlog(n)) time | O(1) space, where n is the number of coins.
    static int non_constructible_change2(int[] coins) {
        if (coins == null || coins.length == 0) return 1;
        Arrays.sort(coins);

        int currentChange = 0;
        for (int coin : coins) {
            if (coin > currentChange + 1)
                return currentChange + 1;

            currentChange += coin;
        }

        return currentChange + 1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 5, 7, 22};

        System.out.println(non_constructible_change(arr));
        System.out.println(non_constructible_change2(arr));
    }
}
