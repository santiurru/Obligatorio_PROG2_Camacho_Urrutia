/**
 * 
 */
package uy.edu.um.adt.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pegardan
 *
 */
public class TreeNode<T extends Comparable<T>> {

	private T value;

	private TreeNode<T> left;

	private TreeNode<T> right;

	public TreeNode(T oValue) {
		this.value = oValue;
	}

	public void add(T oElement) {
		int nValue = oElement.compareTo(this.value);
		TreeNode<T> oElementToAdd = new TreeNode<T>(oElement);

		if (nValue > 0) {

			if (this.right == null) {

				this.right = oElementToAdd;

			} else {

				this.right.add(oElement);

			}

		} else {

			if (this.left == null) {

				this.left = oElementToAdd;

			} else {

				this.left.add(oElement);

			}
		}

	}

	public TreeNode<T> remove(T oElement) {
		int nValue = ((Comparable<T>) oElement).compareTo(this.value);

		if (nValue > 0) {

			if (this.right != null) {

				this.right = this.right.remove(oElement);

			}

		} else if (nValue < 0) {

			if (this.left != null) {

				this.left = this.left.remove(oElement);

			}
		} else if (this.left != null && this.right != null) {

			// Encontre el elemento a eliminar

			this.value = this.right.findMin();    //cambio el nodo a borrar por el nodo mas bajo en la rama del derecho de este

			this.right = this.right.remove(this.value);

		} else {

			if (this.left != null) {

				return this.left;

			} else {

				return this.right;

			}

		}

		return this;
	}

	public List<T> inOrderTraverse() {
		List<T> colList = new ArrayList<T>();

		if (this.left != null) {

			colList.addAll(this.left.inOrderTraverse());

		}

		colList.add(this.value);

		if (this.right != null) {

			colList.addAll(this.right.inOrderTraverse());

		}

		return colList;
	}

	public List<T> preOrderTraverse() {
		List<T> colList = new ArrayList<T>();

		colList.add(getValue());

		if (this.left != null) {

			colList.addAll(this.left.preOrderTraverse());

		}

		if (this.right != null) {

			colList.addAll(this.right.preOrderTraverse());

		}

		return colList;
	}

	public List<T> postOrderTraverse() {
		List<T> colList = new ArrayList<T>();

		if (this.left != null) {

			colList.addAll(this.left.preOrderTraverse());

		}

		if (this.right != null) {

			colList.addAll(this.right.preOrderTraverse());

		}

		colList.add(getValue());

		return colList;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return this.right;
	}

	public void setRigth(TreeNode<T> rigth) {
		this.right = rigth;
	}

	public T findMin() {
		T oReturn = this.value;

		if (this.left != null) {

			oReturn = this.left.findMin();

		}

		return oReturn;
	}

}
