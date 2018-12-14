/*
 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 *
 * Input:
 * ----------------
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * The first line of each test case contains a single integer N denoting the size of array. The second line contains
 * N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * ----------------
 * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 *
 * Constraints:
 * ----------------
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 1000
 * -100 ≤ A[i] <= 100
 *
 * Example:
 * --------------
 *
 * Input
 * --------------
 * 2
 * 3
 * 1 2 3
 * 4
 * -1 -2 -3 -4
 *
 * Output
 * --------------
 * 6
 * -1
 *
 */


package org.redquark.problemsolving.gfg.arrays;

import java.util.Scanner;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Reading the number of test cases
        int testCases = scanner.nextInt();

        // This loop will iterate for each test case
        for (int i = 0; i < testCases; i++) {

            // Number of elements in the array
            int n = scanner.nextInt();

            // Initializing an array with size n
            int[] arr = new int[n];

            // Reading values for the array
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            // Calling the method that will calculate the maximum sum array with contiguous values
            System.out.println(maximumArraySum(arr));
        }
    }

    /**
     * This method will calculate the maximum sum array with contiguous values
     */
    private static int maximumArraySum(int[] arr) {

        // Let us assume that maximum contiguous array is with one value only i.e. the first value
        int max = arr[0], maxSum = arr[0];

        // Now we will check if there exists an array with sum of elements greater than the maxSum
        for (int i = 1; i < arr.length; i++) {

            // Here, we are finding which is greater - current element or the sum of current element
            // and the previous sub array sum
            max = arr[i] > max + arr[i] ? arr[i] : max + arr[i];

            // Here, we are checking if the current iteration has the maximum sum so far
            maxSum = max > maxSum ? max : maxSum;
        }

        return maxSum;
    }
}
