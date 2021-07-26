package AlgoExpert;

public class BubbleSort {

    //Worst: O(n^2) time | O(1) space, where n is the length of the input array.
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
            printArr(array);
            if (isSorted) break;

        }

        return array;
    }




    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
        printArr(bubbleSort(array));

    }


    static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }


}
