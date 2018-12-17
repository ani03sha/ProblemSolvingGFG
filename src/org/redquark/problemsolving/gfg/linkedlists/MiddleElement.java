/*
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5
 * then output should be 3.
 *
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 *
 * Input:
 * You have to complete the method which takes one argument: the head of the linked list.
 * You should not read any input from stdin/console.
 *
 * The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * Output:
 * Your function should return data of linked list.  If linked list is empty, then return -1.
 *
 * Constraints:
 * 1 <=T<= 100
 * 1 <=N<= 100
 * 1 <=value<= 1000
 *
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 6
 * 2 4 6 7 5 1
 *
 * Output:
 * 3
 * 7
 */


package org.redquark.problemsolving.gfg.linkedlists;

import java.util.Scanner;

public class MiddleElement {

    private static Node head;  // head of list

    /* Driver program to test above functions */
    public static void main(String[] args) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();

            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();

            Node head = new Node(a1);

            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            System.out.println(getMiddle(MiddleElement.head));

            t--;
        }
    }

    private static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    private static int getMiddle(Node head) {

        // Base case
        if (head == null) {
            return -1;
        }

        // Two pointers - slow and fast
        Node slow = head;
        Node fast = head;

        // Iterating through the list
        while (fast != null && fast.next != null) {

            // Fast pointer will jump two steps at a time
            fast = fast.next.next;

            // Slow pointer will jump one step at a time
            slow = slow.next;
        }

        // When fast reaches end, the slow will be in the middle
        return slow.data;
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
