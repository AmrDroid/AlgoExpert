package AlgoExpert;

public class BinarySearch {

    //O(log(n)) time | O(log(n)) space, where the n is the length of the input array.
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
    //////////////////////////////////////////////////////

    //O(log(n)) time | O(1) space, where n is the number of integers in the input array.
    public static int binarySearch2(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) return mid;

            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch2(array, 5));

    }


}
