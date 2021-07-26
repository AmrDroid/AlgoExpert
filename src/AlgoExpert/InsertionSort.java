package AlgoExpert;

public class InsertionSort {

//    Time Complexity: O(n^2)
//    Space: O(1)
    public static int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) return new int[] {};
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                --j;
            }
        }

        return array;
    }


}
