package AlgoExpert;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {

        int []arr = new int[3];
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

    static void printarray(int[] arr) {
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 4, 5, 1, 2, 7, 3};
        int []arr = findThreeLargestNumbers(array);
        for (int i : arr)
            System.out.print(i + "  ");

    }

}
