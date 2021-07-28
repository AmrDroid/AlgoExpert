package AlgoExpert.Easy;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {

    static int[] hasArrayTwoCandidates(int arr[], int sum) {
        int index0 = 0;
        int index1 = 0;
        int res[] = new int[2];
        while (index1 < arr.length && index0 < arr.length) {
            if (index0 != index1) {
                if (sum == arr[index0] + arr[index1]) {
                    res[0] = arr[index0];
                    res[1] = arr[index1];
                    return res;
                }
            }
            if (index1 == arr.length - 1) {
                index1 = 0;
                index0++;
            } else
                index1++;
        }
        return null;
    }


    static int[] hasArrayTwoCandidates2(int A[], int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = A.length - 1;
        while (l < r) {
            if (A[l] + A[r] == sum) {
                int arr[] = {A[l], A[r]};
                return arr;
            } else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return null;
    }

    static int[] hasArrayTwoCandidates3(int arr[], int sum) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            // checking for condition
            if (s.contains(temp)) {
                return new int[]{arr[i], temp};

            }
            s.add(arr[i]);
        }
        return null;
    }

    static int[] hasArrayTwoCandidates4(int a[], int x) {
        int i;
        int n = a.length;
        int[] rem = new int[x];
        for (i = 0; i < x; i++) {
            rem[i] = 0;
        }

        for (i = 0; i < n; i++) {
            if(a[i]==0)
                rem[a[i]]++;
            else if (a[i] < x) {
                rem[a[i] % x]++;
            }
        }
        int r=0;
        for (i = 0; i < x / 2; i++) {
            System.out.println(i);
            if(i==0) r=rem[0];
            else r=rem[x-i];

            if (rem[i] > 0 && r > 0) {
                return new int[]{i, x - i};
            }
        }

        if (i >= x / 2) {
            if (x % 2 == 0) {
                if (rem[x / 2] > 1) {
                    return new int[]{x / 2, x / 2};
                }
            } else {
                if (rem[x / 2] > 0 && rem[x - x / 2] > 0) {
                    return new int[]{x/2,0};
                }
            }
        }
        return null;

    }


    public static void main(String args[]) {
        int A[] = {1, 10, 45, 6, 16, 8};
        int n = 16;

        int[] a = hasArrayTwoCandidates4(A, n);
        // Function calling

        if (a != null) System.out.println(a[0] + "   " + a[1]);
        else System.out.println("null");
    }
}