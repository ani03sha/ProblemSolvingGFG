/*
 * Given a linked list, check if the the linked list has a loop. Linked list can contain self loop.
 *
 * Input:
 *
 * In this problem, method takes one argument: the head of the linked list. The function should not read any
 * input from stdin/console.
 * The node structure has a data part which stores the data and a next pointer which points to the next element
 * of the linked list.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * Output:
 *
 * Return 1 if linked list has a loop else 0.
 *
 * Constraints:
 *
 * 1<=T<=50
 * 1<=N<=300
 *
 * Example:
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
 *
 * True
 * False
 *
 * Explanation:
 *
 * In above test case N = 3
 *
 * The linked list with nodes N = 3 is given. Then value of x=2 is given which means last node is connected with
 * xth node of linked list. Therefore, there exists a loop.
 *
 * For N = 4
 * x = 0 means then lastNode->next = NULL, then the Linked list does not contains any loop.
 */


package org.redquark.problemsolving.gfg.linkedlists;

import java.util.Scanner;

public class DetectLoop {

    private static Node head;  // head of list

    /* Linked list Node*/
    /* Inserts a new Node at front of the list. */
    private static void push(int new_data) {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Drier program to test above functions */
    public static void main(String[] args) {
        int t, d, n, i, x, c;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (d = 0; d < t; d++) {
            n = sc.nextInt();
            Node q;
            for (i = 0; i < n; i++) {
                x = sc.nextInt();
                push(x);
            }
            Node p;
            p = head;
            q = head;
            while (q.next != null)
                q = q.next;
            c = sc.nextInt();
            if (c > 0) {
                c = c - 1;
                for (i = 0; i < c; i++) {
                    p = p.next;
                }
                q.next = p;
            }
            if (detectLoop(head) == 1)
                System.out.print("True");
            else
                System.out.print("False");
            System.gc();
        }
    }

    private static int detectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
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
