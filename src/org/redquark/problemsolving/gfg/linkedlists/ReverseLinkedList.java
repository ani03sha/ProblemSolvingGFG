/*
 * Given pointer to the head node of a linked list, the task is to reverse the linked list.
 *
 * Input:
 * You need to complete a method reverse() that takes head as argument and returns new head.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * The first line of input contains number of test cases.  Every test case has two lines,
 * number of nodes first line and data values in next line.
 *
 * Output:
 * Reverse the linked list and return head of the modified list.
 *
 *
 * Example:
 * Input:
 * 1
 * 6
 * 1 2 3 4 5 6
 *
 * Output:
 * 6 5 4 3 2 1
 */


package org.redquark.problemsolving.gfg.linkedlists;

import java.io.*;

public class ReverseLinkedList {

    private static Node head;  // head of list
    private static Node lastNode;
    private static PrintWriter out;

    private static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            lastNode.next = node;
            lastNode = node;
        }
    }

    /* Function to print linked list */
    private static void printList() {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }

    /* Drier program to test above functions */
    public static void main(String[] args) throws IOException {
        /* Constructed Linked List is 1->2->3->4->5->6->
         7->8->8->9->null */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            if (n > 0) {
                int a1 = Integer.parseInt(nums[0]);
                Node head = new Node(a1);
                addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(nums[i]);
                addToTheLast(new Node(a));
            }
            head = reverse(head);

            printList();

            t--;
        }
        out.close();
    }

    private static Node reverse(Node head) {

        // Base case
        if (head == null) {
            return head;
        }

        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

        return head;
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
