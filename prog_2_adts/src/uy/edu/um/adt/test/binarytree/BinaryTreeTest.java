package uy.edu.um.adt.test.binarytree;

import org.junit.jupiter.api.Test;
import uy.edu.um.adt.binarytree.BinaryTree;
import uy.edu.um.adt.binarytree.SearchBinaryTreeImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    @Test
    void BinaryTreeTest(){
        SearchBinaryTreeImpl<Integer> tempTree = new SearchBinaryTreeImpl<Integer>();
        tempTree.add(34);
        tempTree.add(13);
        tempTree.add(54);
        tempTree.add(2);
        tempTree.add(43);
        tempTree.add(67);
        assertEquals(true,tempTree.contains(34));
        assertEquals(true,tempTree.contains(13));
        assertEquals(true,tempTree.contains(54));
        assertEquals(true,tempTree.contains(2));
        assertEquals(true,tempTree.contains(43));
        assertEquals(true,tempTree.contains(67));
        tempTree.remove(34);
        assertEquals(false,tempTree.contains(34));
        assertEquals(43,tempTree.getRoot().getValue());
        assertEquals(5, tempTree.size());
        assertEquals(2, tempTree.find(2));
    }
}
