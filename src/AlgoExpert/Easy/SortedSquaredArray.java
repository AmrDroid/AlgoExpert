package AlgoExpert.Easy;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void sortSquares(int arr[]) {
        int n = arr.length;

        // First convert each array elements
        // into its square
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        // Sort an array using "inbuild sort function"
        // in Arrays class.
        Arrays.sort(arr);
    }

    public static void sortSquares2(int arr[]) {
        int n = arr.length;
        // first dived array into part negative and positive
        int k;
        for (k = 0; k < n; k++) {
            if (arr[k] >= 0)
                break;
        }

        // Now do the same process that we learn
        // in merge sort to merge to two sorted array
        // here both two half are sorted and we traverse
        // first half in reverse meaner because
        // first half contain negative element
        int i = k - 1; // Initial index of first half
        int j = k; // Initial index of second half
        int ind = 0; // Initial index of temp array

        int[] temp = new int[n];
        while (i >= 0 && j < n) {
            if (arr[i] * arr[i] < arr[j] * arr[j]) {
                temp[ind] = arr[i] * arr[i];
                i--;
            } else {
                temp[ind] = arr[j] * arr[j];
                j++;
            }
            ind++;
        }

        while (i >= 0) {
            temp[ind++] = arr[i] * arr[i];
            i--;
        }
        while (j < n) {
            temp[ind++] = arr[j] * arr[j];
            j++;
        }

        // copy 'temp' array into original array
        for (int x = 0; x < n; x++)
            arr[x] = temp[x];
    }


    public static void sortSquares3(int arr[])
    {
        int n = arr.length, left = 0,
                right = n - 1;

        int result[] = new int[n];

        for(int index = n - 1; index >= 0; index--)
        {
            if (Math.abs(arr[left]) > arr[right])
            {
                result[index] = arr[left] * arr[left];
                left++;
            }
            else
            {
                result[index] = arr[right] * arr[right];
                right--;
            }
        }
        for(int i = 0; i < n; i++)
            arr[i] = result[i];
    }




    public static void main(String args[]) {
        int A[] = {-15, -1, 6, 8, 10, 16, 45};

        sortSquares3(A);
        // Function calling

        for (int x : A)
            System.out.println(x);
    }

}
