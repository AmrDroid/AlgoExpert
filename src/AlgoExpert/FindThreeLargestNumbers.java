package AlgoExpert;

public class FindThreeLargestNumbers {
    //O(n) time | O(1) space, where n is the length of the input array.
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] arr = new int[3];
        int index = 0;
        for (int i = array.length - 1; i >= array.length - 3; i--) {
            int largestNumIdx = 0;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[largestNumIdx]) {
                    largestNumIdx = j;
                }
            }
            int temp = array[i];
            array[i] = array[largestNumIdx];
            array[largestNumIdx] = temp;
            arr[index++] = array[i];
        }
        return arr;
    }

    ////////////////////////////////////////////////////////////////////
//O(n) time | O(1) space, where n is the length of the input array.
    static int[] findThreeLargestNumbers2(int[] array) {
        int[] threeLargestNums = new int[3];

        for (int num : array) {
            updateThreeLargestNums(threeLargestNums, num);
        }
        return threeLargestNums;
    }

    static void updateThreeLargestNums(int[] threeLargestNums, int num) {
        int thirdLargestNum = threeLargestNums[0];
        int secondLargestNum = threeLargestNums[1];
        int largestNum = threeLargestNums[2];
        if (num > largestNum) {
            shiftAndUpdate(threeLargestNums, num, 2);
        } else if (num > secondLargestNum) {
            shiftAndUpdate(threeLargestNums, num, 1);
        } else if (num > thirdLargestNum) {
            shiftAndUpdate(threeLargestNums, num, 0);
        }
    }

    //5 7 8
    static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
        int[] arr = findThreeLargestNumbers(array);

        printArr(arr);
        printArr(findThreeLargestNumbers2(array));

    }


    static void printArr(int []arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }
}
