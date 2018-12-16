/*
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow.
 * Each testcases contains two lines of input. The first line denotes the size of the array N.
 * The second lines contains the elements of the array A separated by spaces.
 *
 * Output:
 * For each testcase, print the sorted array.
 *
 * Constraints:
 * 1 <= T <= 500
 * 1 <= N <= 106
 * 0 <= Ai <= 2
 *
 * Example:
 * Input :
 * 2
 * 5
 * 0 2 1 2 0
 * 3
 * 0 1 0
 *
 * Output:
 * 0 0 1 2 2
 * 0 0 1
 *
 * Explanation:
 * Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */


package org.redquark.problemsolving.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DutchNationalFlagSorting {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {

            // Reading the number of test cases
            int testCases = Integer.parseInt(bufferedReader.readLine());

            // This loop will iterate for each test case
            for (int i = 0; i < testCases; i++) {

                // Number of elements in the array
                int n = Integer.parseInt(bufferedReader.readLine());

                // Initializing an array with size n
                int[] arr = new int[n];

                // To read multiple integers in a line
                String line = bufferedReader.readLine();

                String[] values = line.trim().split("\\s+");

                // Reading values for the array
                for (int j = 0; j < values.length; j++) {
                    arr[j] = Integer.parseInt(values[j]);
                }

                // Calling the method that will sort the array
                sort(arr, n);

                //Printing the sorted array
                print(arr, n);

                System.out.println();
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sort(int[] arr, int n) {

        // Declaring three pointers
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {

            if (arr[mid] == 2) {
                swap(arr, mid, high--);
            } else if (arr[mid] == 0) {
                swap(arr, mid++, low++);
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}

