/*
 * Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is N(the size of array). The second line of each test case contains array elements.
 *
 * Output:
 * For each test case print the required answer in new line.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 106
 * 1 ≤ Ai ≤ 106
 *
 * Example:
 * Input:
 * 2
 * 7
 * 1 101 2 3 100 4 5
 * 4
 * 10 5 4 3
 *
 * Output:
 * 106
 * 10
 *
 * Explanation:
 * Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5).
 * Out of these (1, 2, 3, 100) has maximum sum,i.e., 106.
 */


package org.redquark.problemsolving.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {

        // BufferedReader to read input from the console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Number of test cases
            int testCases = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < testCases; i++) {

                // Reading the number of elements in the array
                int n = Integer.parseInt(bufferedReader.readLine());

                // Array to store integers
                int[] arr = new int[n];

                // Reading the values/elements of the array
                String[] values = bufferedReader.readLine().trim().split("\\s+");

                // Converting the values into the integers and store them in arr
                for (int j = 0; j < n; j++) {
                    arr[j] = Integer.parseInt(values[j]);
                }

                // Find the maximum sum increasing subsequence
                System.out.println("Recursive: " + maxSumIncreasingSubsequenceRecursive(arr, 0, n, Integer.MIN_VALUE, 0));
                System.out.println("Iterative: " + maxSumIncreasingSubsequenceIterative(arr, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int maxSumIncreasingSubsequenceRecursive(int[] arr, int i, int n, int prev, int sum) {

        // Base case - Nothing is remaining
        if (i == n) {
            return sum;
        }

        // Case 1 - exclude the current element and process the remaining elements
        int x = maxSumIncreasingSubsequenceRecursive(arr, i + 1, n, prev, sum);

        // Case 2 - Include the current element if it is greater than the previous element
        int y = sum;
        if (arr[i] > prev) {
            y = maxSumIncreasingSubsequenceRecursive(arr, i + 1, n, arr[i], sum + arr[i]);
        }

        return Integer.max(x, y);
    }

    private static int maxSumIncreasingSubsequenceIterative(int[] arr, int n) {

        // Array to store sub-problem solution. sum[i] stores maximum sum of subsequence ending with arr[i].
        int[] sum = new int[n];

        // Base case
        sum[0] = arr[0];

        // Starting from the second element in the array
        for (int i = 1; i < n; i++) {

            // Do for each element in subarray arr[0...i]
            for (int j = 0; j < i; j++) {

                // Find increasing subsequence with maximum sum that ends with arr[j]
                // where arr[j] is less than current element arr[i]
                if (sum[i] < sum[j] && arr[i] > arr[j]) {
                    sum[i] = sum[j];
                }
            }

            sum[i] = sum[i] + arr[i];
        }

        // Return the maximum sum
        return Arrays.stream(sum).max().getAsInt();
    }
}
