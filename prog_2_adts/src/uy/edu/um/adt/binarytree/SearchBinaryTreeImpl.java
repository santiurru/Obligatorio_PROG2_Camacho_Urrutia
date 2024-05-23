/**
 * 
 */
package uy.edu.um.adt.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pegardan
 * @param <T>
 *
 */
public class SearchBinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

	private TreeNode<T> root;

	public SearchBinaryTreeImpl() {
	}

	public TreeNode<T> getRoot() {
		return this.root;
	}

	public void add(T oElement) {
		TreeNode<T> oElementToAdd = new TreeNode<T>(oElement);

		if (this.root == null) {

			this.root = oElementToAdd;

		} else {

			this.root.add(oElement);

		}
	}

	public boolean contains(T oElement) {
		return this.contains(oElement, this.root);
	}

	private boolean contains(T oElementToSearch, TreeNode<T> oTree) {
		boolean bContains = false;
		
		if (oTree != null) {

			int nValue = oElementToSearch.compareTo(oTree.getValue());
					
			if (nValue == 0) {
				
				bContains = true;
			
			} else if (nValue > 0) {
				
				bContains = this.contains(oElementToSearch, oTree.getRight());
		
			} else {
				
				bContains = this.contains(oElementToSearch, oTree.getLeft());
			
			}

		}

		return bContains;
	}

	public void remove(T oElement) {

		if (root != null) {

			root.remove(oElement);

		}

	}
	
	public T find(T oElement) {

		return find(oElement, root);
	}
	
	private T find(T oElementToSearch, TreeNode<T> oTree) {
		T oSearchedElement = null;
		
		if (oTree != null) {

			int nValue = oElementToSearch.compareTo(oTree.getValue());
					
			if (nValue == 0) {
				
				oSearchedElement = oTree.getValue();
			
			} else if (nValue > 0) {
				
				oSearchedElement = find(oElementToSearch, oTree.getRight());
		
			} else {
				
				oSearchedElement = find(oElementToSearch, oTree.getLeft());
			
			}

		}

		return oSearchedElement;
	}		

	public List<T> preOrder() {
		List<T> colValues = new ArrayList<T>();

		if (this.root != null) {

			colValues.addAll(this.root.preOrderTraverse());

		}

		return colValues;
	}

	public List<T> posOrder() {
		List<T> colValues = new ArrayList<T>();

		if (this.root != null) {

			colValues.addAll(this.root.postOrderTraverse());

		}

		return colValues;
	}

	public List<T> inOrder() {
		List<T> colValues = new ArrayList<T>();

		if (this.root != null) {

			colValues.addAll(this.root.inOrderTraverse());

		}

		return colValues;
	}

	public int size() {
		return size(this.root);
	}

	public int size(TreeNode<T> tempRoot){
		if (tempRoot == null){
			return 0;
		}
		return 1 + size(tempRoot.getLeft()) + size(tempRoot.getRight());
	}
}
