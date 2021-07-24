package AlgoExpert;

public class BinarySearch {


    private static int binarySearch(int[] array, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        else if (array[mid] < target) return binarySearch(array, mid + 1, right, target);
        else return binarySearch(array, left, mid - 1, target);
    }

    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;
        return binarySearch(array, 0, array.length - 1, target);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 5));

    }


}
