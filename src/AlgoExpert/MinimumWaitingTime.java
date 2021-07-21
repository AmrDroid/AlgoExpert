package AlgoExpert;

import java.util.Arrays;

public class MinimumWaitingTime {


    //O(nlog(n)) time | O(1) space, where n is the number of queries.
    public static int minimumWaitingTime(int[] arr) {
        Arrays.sort(arr);
        int totalWaitingTime = 0;
        int waitingTime = 0;

        for (int duration : arr) {
            totalWaitingTime += waitingTime;
            waitingTime += duration;
        }
        return totalWaitingTime;

    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 2};
        System.out.println(minimumWaitingTime(arr));
        System.out.println(minimumWaitingTime2(arr));
    }

//O(nlog(n)) time | O(1) space, where n is the number of queries.
   public static int minimumWaitingTime2(int[] queries) {

        // 0 + 1 + (1+2)
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        for (int idx = 0; idx < queries.length; idx++) {
            int duration = queries[idx];
            int queriesLeft = queries.length - (idx + 1);
            totalWaitingTime += duration * queriesLeft;
        }

        return totalWaitingTime;
    }

}
