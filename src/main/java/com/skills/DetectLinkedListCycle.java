package com.skills;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 20:21
 */
public class DetectLinkedListCycle {
    public class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    boolean hasCycle(Node head) {
        if (head == null) return false;
        Node fast=head;
        Node slow = head;
        while (slow!=null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
