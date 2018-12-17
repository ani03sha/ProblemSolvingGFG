/*
 * Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array.
 * Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases then T test cases follow.
 * First line of each test case contains an integer N denoting the size of the array.
 * Then in the next line are N space separated values of the array A.
 *
 * Output:
 * For each test case in a new  line print the position at which the elements are at equilibrium
 * if no equilibrium point exists print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 106
 * 1 <= Ai <= 108
 *
 * Example:
 * Input:
 * 2
 * 1
 * 1
 * 5
 * 1 3 5 2 2
 *
 * Output:
 * 1
 * 3
 *
 * Explanation:
 * Testcase 1: Since its the only element hence its the only equilibrium point.
 * Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).
 */


package org.redquark.problemsolving.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class EquilibriumPoint {

    public static void main(String[] args) {

        // BufferedReader to read input from the console
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testCases = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < testCases; i++) {

                // Reading the size of the array
                int n = Integer.parseInt(bufferedReader.readLine());

                // Initializing the array that will store the values
                int[] arr = new int[n];

                // Reading the elements of the array
                String[] values = bufferedReader.readLine().trim().split("\\s+");

                // Convert thee values into integers
                for (int j = 0; j < n; j++) {
                    arr[j] = Integer.parseInt(values[j]);
                }

                // Finding the equilibrium point's position
                System.out.println(findEquilibriumPoint(arr, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findEquilibriumPoint(int[] arr, int n) {

        // Sum of all the elements of array arr
        int sum = IntStream.of(arr).sum();

        // Sum of left elements of the ith element
        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            // Subtracting the ith element from the total sum
            sum = sum - arr[i];

            // Comparing if the total sum is equal to the sum of left elements of ith element
            if (sum == leftSum) {
                return ++i;
            }

            // Updating leftSum value
            leftSum = leftSum + arr[i];
        }

        return -1;
    }
}
