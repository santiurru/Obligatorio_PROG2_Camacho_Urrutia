package uy.edu.um.prog2.adt.test.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


public class ListTest {
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
        assertEquals(false, tempList.isEmpty());
        tempList.remove(1);
        tempList.remove(3);
        tempList.remove(4);
        assertEquals(true, tempList.isEmpty());
    }
}
