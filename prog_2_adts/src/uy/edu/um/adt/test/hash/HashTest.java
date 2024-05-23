package uy.edu.um.adt.test.hash;

import org.junit.jupiter.api.Test;
import uy.edu.um.adt.hash.HashCerrado;
import uy.edu.um.adt.hash.NoPerteneceException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTest {
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
