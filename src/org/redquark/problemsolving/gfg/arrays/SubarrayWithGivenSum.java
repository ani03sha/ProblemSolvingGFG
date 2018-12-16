/*
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 *
 * Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array
 * and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occurring
 * subarray from the left if sum equals to subarray, else print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */


package org.redquark.problemsolving.gfg.arrays;

import java.util.Scanner;

public class SubarrayWithGivenSum {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Reading the number of test cases
        int testCases = scanner.nextInt();

        // This loop will iterate for each test case
        for (int i = 0; i < testCases; i++) {

            // Number of elements in the array
            int n = scanner.nextInt();

            // Given sum
            int s = scanner.nextInt();

            // Initializing an array with size n
            int[] arr = new int[n];

            // Reading values for the array
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            // Calling the method that will give the sum equal to the given number
            System.out.println(subArrayWithSum(arr, s));
        }
    }

    private static String subArrayWithSum(int[] arr, int s) {

        int tempSum = arr[0];
        int start = 0;

        for (int i = 1; i <= arr.length; i++) {

            if (tempSum == s) {
                return ++start + " " + i;
            }

            tempSum = tempSum + arr[i];

            while (tempSum > s && start < i) {
                tempSum = tempSum - arr[start];
                start++;
            }
        }

        return "" + -1;
    }
}
