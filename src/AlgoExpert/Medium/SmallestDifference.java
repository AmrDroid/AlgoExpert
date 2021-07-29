package AlgoExpert.Medium;

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

    public static void main(String[] args) {
        int A[] = {100, 4, 45, 6, 10, 8};
        int B[] = {44, 140, 20, 30, 1000, 80};


        int res[] = smallestDiff(A, B);
        System.out.println(res[0] + "   " + res[1]);

    }
}
