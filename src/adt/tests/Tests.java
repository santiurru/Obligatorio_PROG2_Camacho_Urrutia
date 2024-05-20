package adt.tests;

import adt.linkedlist.MyLinkedListImpl;
import adt.linkedlist.MyList;
import adt.queue.EmptyQueueException;
import adt.queue.MyQueue;
import adt.stack.EmptyStackException;
import adt.stack.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    @Test
    void listTest() {
        MyList<Integer> tempList = new MyLinkedListImpl<>();
        tempList.add(1);
        tempList.add(2);
        tempList.add(3);
        tempList.add(4);
        assertEquals(true, tempList.contains(2));
        assertEquals(4, tempList.size());
        assertEquals(1, tempList.get(0));
        tempList.remove(2);
        assertEquals(false, tempList.contains(2));
    }
    void stackTest(){
        MyStack<Integer> tempStack = new MyLinkedListImpl<>();
        tempStack.push(1);
        tempStack.push(2);
        tempStack.push(3);
        tempStack.push(4);
        try { assertEquals(4, tempStack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);}
        assertEquals(3,tempStack.peek());
        assertEquals(3,tempStack.size());
        assertEquals(1,tempStack.get(0));
        assertEquals(2,tempStack.get(1));
    }
    void queueTest(){
        MyQueue<Integer> tempQueue = new MyLinkedListImpl<>();
        tempQueue.enqueue(1);
        tempQueue.enqueue(2);
        tempQueue.enqueue(3);
        tempQueue.enqueue(4);
        assertEquals(true, tempQueue.contains(1));
        try { tempQueue.dequeue();
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);}
        assertEquals(false,tempQueue.contains(1));
        assertEquals(3,tempQueue.size());
    }
}
