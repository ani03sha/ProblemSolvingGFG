/*
 * Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing,
 * the missing number is to be found.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. For each test case first line
 * contains N(size of array). The subsequent line contains N-1 array elements.
 *
 * Output:
 * Print the missing number in array.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 *
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 5
 * 10
 * 1 2 3 4 5 6 7 8 10
 *
 * Output:
 * 4
 * 9
 */


package org.redquark.problemsolving.gfg.arrays;

import java.util.Scanner;

public class MissingNumberInArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Reading the number of test cases
        int testCases = scanner.nextInt();

        // This loop will iterate for each test case
        for (int i = 0; i < testCases; i++) {

            // Number of elements in the array
            int n = scanner.nextInt();

            // Initializing an array with size n
            int[] arr = new int[n - 1];

            // Reading values for the array
            for (int j = 0; j < n - 1; j++) {
                arr[j] = scanner.nextInt();
            }

            // Calling the method that will give the missing number
            System.out.println(missingNumber(arr, n));
        }
    }

    private static int missingNumber(int[] arr, int n) {

        // We are calculating the sum of first n natural numbers
        int total = n * (n + 1) / 2;

        // This variable will store the value of sum of all the elements in the array
        int arrSum = 0;

        for (int i = 0; i < n - 1; i++) {
            arrSum = arrSum + arr[i];
        }

        // Difference between total and arrSum will give us the missing number
        return (total - arrSum);
    }
}
