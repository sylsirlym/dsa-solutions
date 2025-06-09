package com.skills;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 22:39
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class DetectLinkedListCycleTest {
    private DetectLinkedListCycle detector = new DetectLinkedListCycle();

    @Test
    public void testEmptyList() {
        assertFalse(detector.hasCycle(null));
    }

    @Test
    public void testSingleNodeNoCycle() {
        DetectLinkedListCycle.Node node = detector.new Node(1);
        assertFalse(detector.hasCycle(node));
    }

    @Test
    public void testSingleNodeWithCycle() {
        DetectLinkedListCycle.Node node = detector.new Node(1);
        node.next = node; // Create self-cycle
        assertTrue(detector.hasCycle(node));
    }

    @Test
    public void testTwoNodesNoCycle() {
        DetectLinkedListCycle.Node node1 = detector.new Node(1);
        DetectLinkedListCycle.Node node2 = detector.new Node(2);
        node1.next = node2;
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testTwoNodesWithCycle() {
        DetectLinkedListCycle.Node node1 = detector.new Node(1);
        DetectLinkedListCycle.Node node2 = detector.new Node(2);
        node1.next = node2;
        node2.next = node1; // Create cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testMultipleNodesNoCycle() {
        DetectLinkedListCycle.Node head = createLinearList(5); // 1->2->3->4->5->null
        assertFalse(detector.hasCycle(head));
    }

    @Test
    public void testCycleAtBeginning() {
        DetectLinkedListCycle.Node head = detector.new Node(1);
        DetectLinkedListCycle.Node node2 = detector.new Node(2);
        DetectLinkedListCycle.Node node3 = detector.new Node(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head; // Cycle back to head
        assertTrue(detector.hasCycle(head));
    }

    @Test
    public void testCycleAtMiddle() {
        DetectLinkedListCycle.Node head = createLinearList(5); // 1->2->3->4->5->null
        // Create cycle: 3->4->5->3
        DetectLinkedListCycle.Node node3 = head.next.next;
        DetectLinkedListCycle.Node node5 = node3.next.next;
        node5.next = node3;
        assertTrue(detector.hasCycle(head));
    }

    @Test
    public void testCycleAtEnd() {
        DetectLinkedListCycle.Node head = createLinearList(3); // 1->2->3->null
        // Create cycle: 3->2
        DetectLinkedListCycle.Node node3 = head.next.next;
        node3.next = head.next;
        assertTrue(detector.hasCycle(head));
    }

    @Test
    public void testLargeListNoCycle() {
        DetectLinkedListCycle.Node head = createLinearList(1000);
        assertFalse(detector.hasCycle(head));
    }

    @Test
    public void testLargeListWithCycle() {
        DetectLinkedListCycle.Node head = createLinearList(1000);
        // Create cycle from last node to 500th node
        DetectLinkedListCycle.Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        DetectLinkedListCycle.Node node500 = head;
        for (int i = 1; i < 500; i++) {
            node500 = node500.next;
        }
        tail.next = node500;
        assertTrue(detector.hasCycle(head));
    }

    // Helper method to create a linear list without cycles
    private DetectLinkedListCycle.Node createLinearList(int size) {
        if (size <= 0) return null;

        DetectLinkedListCycle.Node head = detector.new Node(1);
        DetectLinkedListCycle.Node current = head;

        for (int i = 2; i <= size; i++) {
            current.next = detector.new Node(i);
            current = current.next;
        }

        return head;
    }
}
