package AlgoExpert.Easy;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) return new int[] {};
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) if (array[minIndex] >= array[j]) minIndex = j;

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
        printArr(selectionSort(array));
    }


    static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }


}
