package AlgoExpert;

import java.util.Arrays;

public class MinimumWaitingTime {


    //O(nlog(n)) time | O(1) space, where n is the number of queries.
    public static int minimumWaitingTime(int []arr)
    {
        Arrays.sort(arr);
        int totalWaitingTime=0;
        int waitingTime=0;

        for(int duration : arr)
        {
            totalWaitingTime+=waitingTime;
            waitingTime+=duration;
        }
        return totalWaitingTime;

    }
    public static void main(String[] args) {

        int []arr={1, 3, 2};
        System.out.println(minimumWaitingTime(arr));
    }
    }
