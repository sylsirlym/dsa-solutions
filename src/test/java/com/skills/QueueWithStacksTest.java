package com.skills;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 17:52
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueWithStacksTest {
    private QueueWithStacks<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueWithStacks<>();
    }

    @Test
    public void testEnqueueAndDequeueSingleItem() {
        queue.enqueue(1);
        assertEquals(Integer.valueOf(1), queue.dequeue());
    }

    @Test
    public void testEnqueueAndPeekSingleItem() {
        queue.enqueue(1);
        assertEquals(Integer.valueOf(1), queue.peek());
        assertFalse(queue.isEmpty()); // Queue should not be empty after peek
    }

    @Test
    public void testMultipleEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void testMixedEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(Integer.valueOf(1), queue.dequeue());

        queue.enqueue(3);
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void testPeekDoesNotRemove() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(Integer.valueOf(1), queue.peek()); // Multiple peeks should return same value
        assertEquals(Integer.valueOf(1), queue.dequeue()); // Verify the item is still there
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testDequeueEmptyQueue() {
        queue.dequeue();
    }

    @Test(expected = RuntimeException.class)
    public void testPeekEmptyQueue() {
        queue.peek();
    }

    @Test
    public void testLargeNumberOfOperations() {
        for (int i = 0; i < 1000; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(Integer.valueOf(i), queue.dequeue());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testInterleavedOperations() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(Integer.valueOf(1), queue.dequeue());

        queue.enqueue(3);
        assertEquals(Integer.valueOf(2), queue.peek());

        queue.enqueue(4);
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());
    }
}
