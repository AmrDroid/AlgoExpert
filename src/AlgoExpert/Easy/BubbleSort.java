package AlgoExpert.Easy;

public class BubbleSort {

//    Best: O(n) time | O(1) space, where n is the length of the input array.
//    Average: O(n^2) time | O(1) space, where n is the length of the input array.
//    Worst: O(n^2) time | O(1) space, where n is the length of the input array.

    public static int[] bubbleSort(int[] array) {
        for (int idx = array.length - 1; idx >= 0; idx--) {
            boolean isSorted = true;

            for (int j = 0; j < idx; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) break;

        }

        return array;
    }


    public static int[] bubbleSort2(int[] array) {
        boolean isSorted = false;
        int j=0;
        while (!isSorted) {
            isSorted=true;
            for (int i = 0; i < array.length-j-1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
            j++;
        }


        return array;
    }


    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
        printArr(bubbleSort(array));
        printArr(bubbleSort2(array));

    }


    static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }


}
