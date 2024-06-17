package uy.edu.um.prog2.adt.test.queue;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    void queueTest(){
        MyQueue<Integer> tempQueue = new MyLinkedListImpl<>();
        tempQueue.enqueue(1);
        tempQueue.enqueue(2);
        tempQueue.enqueue(3);
        tempQueue.enqueue(4);
        assertEquals(true, tempQueue.contains(1));
        try {
            assertEquals(1,tempQueue.dequeue());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);}
        assertEquals(3,tempQueue.size());
        assertEquals(false, tempQueue.isEmpty());
        assertEquals(4,tempQueue.get(0));
        try {
            assertEquals(2, tempQueue.dequeue());
            assertEquals(3, tempQueue.dequeue());
            assertEquals(4, tempQueue.dequeue());
            assertEquals(true, tempQueue.isEmpty());
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }
    }
}
