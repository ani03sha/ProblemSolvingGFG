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
