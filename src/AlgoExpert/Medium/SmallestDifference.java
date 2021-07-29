package AlgoExpert.Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SmallestDifference {

    //O(n*m) time | O(1)
    public static int[] smallestDiff(int[] arr1, int[] arr2) {
        int smallestDiff = Integer.MAX_VALUE;
        int res[] = new int[2];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int currentDiff = Math.abs(arr1[i] - arr2[j]);
                if (currentDiff < smallestDiff) {
                    smallestDiff = currentDiff;
                    res[0] = arr1[i];
                    res[1] = arr2[j];
                }
            }
        }
        return res;
    }
///////////////////////////////////////////////////////////

    //O(nlog(m) + mlog(m)) time | O(1)
    public static int[] smallestDiff2(int[] arr1, int[] arr2) {
        int smallestDiff = Integer.MAX_VALUE;
        int res[] = new int[2];
        Arrays.sort(arr2);

        for (int firstNum : arr1) {
            int[] arr = findNumBeforeAndAfter(arr2, firstNum);
            int currentDiff = Math.abs(firstNum - arr[0]);
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                res[0] = firstNum;
                res[1] = arr[0];
            }

            currentDiff = Math.abs(firstNum - arr[1]);
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                res[0] = firstNum;
                res[1] = arr[1];
            }

            if (currentDiff == 0) break;
        }

        return res;
    }


    public static int[] findNumBeforeAndAfter(int[] array, int target) {
        int startIdx = 0;
        if (target <= array[startIdx]) {
            return new int[]{Integer.MIN_VALUE, array[startIdx]};
        }

        int endIdx = array.length - 1;
        if (target >= array[endIdx]) {
            return new int[]{array[endIdx], Integer.MAX_VALUE};
        }

        while (startIdx <= endIdx) {
            int midIdx = (int) Math.floor((startIdx + endIdx) / 2);
            if (array[midIdx] == target) {
                return new int[]{Integer.MIN_VALUE, array[midIdx]};
            }
            if (array[midIdx] > target) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return new int[]{array[endIdx], array[startIdx]};
    }


    public static void main(String[] args) {
        int A[] = {100, 4, 45, 6, 10, 8};
        int B[] = {44, 140, 20, 30, 1000, 80};

        int res[] = smallestDiff(A, B);
        System.out.println(res[0] + "   " + res[1]);


        int res2[] = smallestDiff2(A, B);
        System.out.println(res2[0] + "   " + res2[1]);

    }
}
