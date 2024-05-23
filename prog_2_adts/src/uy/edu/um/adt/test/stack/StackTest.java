package uy.edu.um.adt.test.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.stack.EmptyStackException;
import uy.edu.um.adt.stack.MyStack;


public class StackTest {
    @Test
    void stackTest() {
        MyStack<Integer> tempStack = new MyLinkedListImpl<>();
        tempStack.push(1);
        tempStack.push(2);
        tempStack.push(3);
        tempStack.push(4);
        try {
            Assertions.assertEquals(4, tempStack.pop());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(3, tempStack.peek());
        Assertions.assertEquals(3, tempStack.size());
        try {
            Assertions.assertEquals(3,tempStack.pop() );
            Assertions.assertEquals(2, tempStack.pop());
            Assertions.assertEquals(false, tempStack.isEmpty());
            Assertions.assertEquals(1, tempStack.pop());
            Assertions.assertEquals(true, tempStack.isEmpty());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

    }
}
