package uy.edu.um.adt.tests;

import adtOld.linkedlist.MyLinkedListImpl;
import adtOld.linkedlist.MyList;
import adtOld.queue.EmptyQueueException;
import adtOld.queue.MyQueue;
import adtOld.stack.EmptyStackException;
import adtOld.stack.MyStack;
import org.junit.jupiter.api.Test;
import uy.edu.um.adt.tests.hash.HashCerrado;
import uy.edu.um.adt.tests.hash.NoPerteneceException;

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


    @Test
    void hashTest() {
        HashCerrado<Integer, Integer> tempHash = new HashCerrado<>(3);
        tempHash.put(1, 2);
        tempHash.put(2, 6);
        tempHash.put(3, 9);
        assertEquals(true, tempHash.contains(1));
        assertEquals(true, tempHash.contains(2));
        assertEquals(true, tempHash.contains(3));
        assertEquals(false, tempHash.contains(4));
        tempHash.put(4, 68);
        assertEquals(true, tempHash.contains(4));
        try {
            tempHash.remove(2);
        } catch (NoPerteneceException e) {
            throw new RuntimeException(e);
        }
        assertEquals(false, tempHash.contains(2));
    }
}
