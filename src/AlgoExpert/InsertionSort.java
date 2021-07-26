package AlgoExpert;

public class InsertionSort {

    //    Time Complexity: O(n^2)
    //    Space: O(1)
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) return new int[]{};
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }

        return array;
    }

    public static int[] insertionSort2(int[] arr) {
        if (arr == null || arr.length == 0) return new int[]{};
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            printArr(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
     //   printArr(insertionSort(array));
        printArr(insertionSort2(array));

    }


    static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }


}
