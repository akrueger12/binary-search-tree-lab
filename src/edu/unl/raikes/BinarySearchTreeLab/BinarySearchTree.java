package edu.unl.raikes.BinarySearchTreeLab;

/**
 * 
 * This is a binary search tree
 * 
 * @author anna and devin
 *
 */
public class BinarySearchTree {
	boolean verbose = true;
	private BinarySearchNode root = null;
	private int size = 0;

	/**
	 * Insert a person into the tree
	 * 
	 * @param data : the person to be added to the tree
	 */
	public void insert(Person data) {
		boolean inserted = false;
		// if the root doesn't exist, make this person the root
		if (root == null) {
			root = new BinarySearchNode(data);
			inserted = true;
		} // if the root does exist- call insert on the root
		else {
			inserted = root.insert(data);
		} // add to the size
		if (inserted) {
			size++;
		}
	}

	/**
	 * Search the binary search tree
	 * 
	 * @param key : the key you're looking for
	 * @return the Person you've looked for
	 */
	public Person search(int key) {
		// if there is no root - don't bother searching the tree doesn't exist
		if (root == null) {
			return null;
		}
		// search for the key using root methods
		BinarySearchNode found = root.search(key);
		// if you find it, return it, if not return null
		if (found != null) {
			return found.person;
		} else {
			return null;
		}

	}

	/**
	 * Delete the person with the key
	 * @param key : the key of the person you're looking for
	 * @return the person you're looking for
	 */
	public Person delete(int key) {
		Person deleted = null;

		// if the tree has no nodes- return null
		if (root == null) {
			return null;
		} // if the tree has nodes
		else {
			// if you find the key
			if (root.person.key == key) {
				// add fake root in case the element to be removed is the root.
				// (simplifies pointer logic)
				BinarySearchNode auxRoot = new BinarySearchNode(null);
				auxRoot.setLeftChild(root);
				// delete the node
				deleted = root.delete(key);
				// retrieve the root from the fake root (in case it changed)
				root = auxRoot.leftChild;
				// if the root exists
				if (root != null)
					root.parent = null;
			} // if you don't find the key
			else {
				deleted = root.delete(key);
			} // if you delete something subtract from the size 
			if (deleted != null)
				size--;
			return deleted;
		}
	}

	/*
	 * The toString method- using recursion in the BinarySearchNode class to print the whole tree
	 */
	public String toString() {
		String toReturn = "Binary Search Tree of Size: " + size + "\n";
		// print the whole tree :)

		if (root != null) {
			toReturn += root.toString();
		}

		return toReturn;
	}

}
