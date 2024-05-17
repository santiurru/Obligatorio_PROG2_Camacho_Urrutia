package TADS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaTest {
    @Test
    void test(){
        ListaEnlazada<Integer> tempList = new ListaEnlazada<>();
        tempList.addLast(1);
        tempList.add(2, 1);
        tempList.addLast(3);
        tempList.addFirst(4);
        assertEquals(true,tempList.contains(2));
        assertEquals(true,tempList.contains(3));
        assertEquals(4, tempList.size());
        assertEquals(4, tempList.get(0));
    }
}
