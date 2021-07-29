package AlgoExpert.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ThreeNumberSum {


    //Time Complexity: O(n3).
    private static void find3Numbers(int[] a, int arr_size, int sum) {

        for (int i = 0; i < arr_size - 2; i++) {
            for (int j = i + 1; j < arr_size - 1; j++) {
                for (int k = j + 1; k < arr_size; k++) {
                    if (a[i] + a[j] + a[k] == sum)
                        System.out.println(a[i] + "  " + a[j] + "   " + a[k]);
                }
            }
        }
    }

    //Time complexity: O(N^2).
    private static void find3Numbers2(int[] A, int arr_size, int sum) {
        int l, r;
        Arrays.sort(A);
        for (int i = 0; i < arr_size - 2; i++) {
            l = i + 1;
            r = arr_size - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.println(A[i] + "  " + A[l] + "   " + A[r]);
                    return;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;
                else
                    r--;
            }
        }
    }


    //    Time complexity: O(N^2)
//    Auxiliary Space: O(N)
    private static void find3Numbers3(int[] A, int arr_size, int sum) {
        for (int i = 0; i < arr_size - 2; i++) {
            HashSet<Integer> s = new HashSet<>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf(A[i] + "  " + A[j] + "   " + (curr_sum - A[j]));
                    return;
                }
                s.add(A[j]);
            }
        }
    }


    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

//        find3Numbers(A, arr_size, sum);
//        find3Numbers2(A, arr_size, sum);
        find3Numbers3(A, arr_size, sum);
    }

}
