/*
 * Given a linked list, the task is to find the n'th node from the end.  It is needed to complete a method
 * that takes two argument, head of linked list and an integer n. There are multiple test cases.
 * For each test case, this method will be called individually.
 *
 *
 * Input:
 * The first line of input contains number of test cases.  Every test case cntains two lines.
 * First line of every test case contains two space separated values, number of nodes  in
 * linked list followed by value of n.  Second line of every test case contains data items of linked list.
 *
 *
 * Output:
 * Corresponding to each test case, output a single integer that is the nth integer in the linked list from the end.
 * Print -1 if the value of n is greater than the number of elements in the linked list.
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= No of Nodes <= 1000
 * 0 <= Data in Nodes <= 1000
 *
 *
 * Example:
 * Input:
 * 2
 * 9 2
 * 1 2 3 4 5 6 7 8 9
 * 4 5
 * 10 5 100 5 1
 *
 *
 * Output:
 * 8
 * -1
 *
 * In the first example, there are 9 nodes in linked list and we need to find 2nd node from end.
 * 2nd node from end os 8.   In the second example, there are 4 nodes in linked list and we need to find 5th from end.
 * Since 'n' is more than number of nodes in linked list, output is -1.
 */


package org.redquark.problemsolving.gfg.linkedlists;

import java.util.Scanner;

public class NthNodeFromEnd {

    private static Node head;

    /* Inserts a new Node at front of the list. */
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

    /* Driver program to test above functions */
    public static void main(String[] args) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            System.out.println(getNthFromLast(head, k));

            t--;
        }
    }

    private static int getNthFromLast(Node head, int k) {

        Node slow = head;
        Node fast = head;

        int count = 0;

        while (fast != null) {
            count++;
            fast = fast.next;
        }

        if (k > count) {
            return -1;
        }

        fast = head;

        while (k != 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (count < k) {
            return -1;
        }

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
