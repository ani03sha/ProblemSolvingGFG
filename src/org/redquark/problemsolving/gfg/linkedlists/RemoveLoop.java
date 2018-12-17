/*
 * Given a linked list, remove the loop in it if present. The task is to complete the function removeTheLoop
 * which takes only one argument the head of the linked list . The function removes the loop in the linked list if present.
 *
 * Input:
 * The first line of input will contain an integer T denoting the no of test cases . Then T test cases follow.
 * Each test case contains 3 lines . The first line of each test case contains an integer N denoting the no of
 * nodes of the linked list . In the next line are N space separated values denoting the values of the linked list.
 * The next line after it contains an integer x denoting that the last node of the linked list pointing to the xth node
 * thus resulting in cycle.
 *
 * Output:
 * Your task is to remove the cycle if present output for each test case will be 1 if the loop is successfully removed
 * from the linked list else 0.
 *
 * Constraints:
 * 1<=T<=50
 * 1<=N<=300
 *
 * Example(To be used only for expected output) :
 *
 * Input:
 *
 * 2
 * 3
 * 1 3 4
 * 2
 * 4
 * 1 8 3 4
 * 0
 *
 * Output:
 * 1
 * 1
 *
 * Explanation:
 *
 * In the first test case N = 3
 * The linked list with nodes N = 3 is given. here x=2 which means last node is connected with xth node of linked list.
 * Therefore, there exists a loop.
 *
 * In the second test where N = 4 and x = 0, which means lastNode->next = NULL, thus the Linked list does not contains any loop.
 */


package org.redquark.problemsolving.gfg.linkedlists;

import java.util.Scanner;

public class RemoveLoop {

    private static Node head;
    private static Node lhead;

    private static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n != 0) {
                int a1 = sc.nextInt();
                Node head = new Node(a1);
                lhead = head;
                addToTheLast(head);
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    addToTheLast(new Node(a));
                }
            }


            Node tt = head;
            while (tt.next != null)
                tt = tt.next;

            int l = sc.nextInt();
            if (n >= l) {
                while (l > 1) {
                    lhead = lhead.next;
                    l--;
                }

                tt.next = lhead;

            }

            int z = removeTheLoop(head);
            if (z == 1)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    private static int removeTheLoop(Node head) {

        // Base case
        if (head == null) {
            return 0;
        }

        // Initializing slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Detect the loop in the linked list
        while (slow != null && fast != null && fast.next != null) {

            // Jump slow pointer one step at a time
            slow = slow.next;

            // Jump fast pointer two steps at a time
            fast = fast.next.next;

            // Check if loop exists
            if (slow == fast) {
                break;
            }
        }

        // Reinitialize slow pointer to head
        slow = head;

        // Move slow and fast pointer one step at a time
        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next;

            // If both slow and fast meet, it means the node is the start of the loop
            if (slow == fast) {

                // Make the next pointer null of the first node of the loop
                fast.next = null;

                return 1;
            }
        }

        return 0;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

}
