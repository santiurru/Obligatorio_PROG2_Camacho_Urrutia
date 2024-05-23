package uy.edu.um.adt.test.binarytree;

import uy.edu.um.adt.binarytree.SearchBinaryTreeImpl;

public class TraverseTest {
    public static void main(String[] args) {
        SearchBinaryTreeImpl<Integer> tempTree = new SearchBinaryTreeImpl<Integer>();
        tempTree.add(34);
        tempTree.add(13);
        tempTree.add(54);
        tempTree.add(2);
        tempTree.add(43);
        tempTree.add(67);
        System.out.println(tempTree.inOrder());
        System.out.println(tempTree.posOrder());
        System.out.println(tempTree.preOrder());
    }
}
