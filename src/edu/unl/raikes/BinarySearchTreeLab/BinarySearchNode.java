package edu.unl.raikes.BinarySearchTreeLab;

/**
 * 
 * This is a node
 * 
 * @author anna and devin
 *
 */
class BinarySearchNode {
	protected BinarySearchNode parent;
	protected BinarySearchNode leftChild;
	protected BinarySearchNode rightChild;
	protected Person person;

	/**
	 * Constructor for the node
	 * 
	 * @param person
	 */
	BinarySearchNode(Person person) {
		this.person = person;
	}

	/**
	 * Insert a node into the tree
	 * 
	 * @param data : this is the person to insert
	 * @return true if inserted, false if not
	 */
	boolean insert(Person data) {
		// check to see if this is the person you're looking for
		if (data == this.person) {
			return false;
		}
		// if not the person - figure out if you need to go left or right
		else if (Integer.compare(data.key, person.key) < 0) {
			// if there is no left child
			if (leftChild == null) {
				setLeftChild(new BinarySearchNode(data));
				return true;
			} // insert it on the left
			else {
				return leftChild.insert(data);
			}
		}
		// figure out if you need to go left or right
		else if (Integer.compare(data.key, person.key) > 0) {
			// if the right child is null - put the new data on the right
			if (rightChild == null) {
				setRightChild(new BinarySearchNode(data));
				return true;
			} // recursively call insert on the right node if it exists
			else {
				return rightChild.insert(data);
			}
		}
		return false;
	}

	/**
	 * Check to see if an object is in the tree
	 * 
	 * @param key : the key to search for
	 * @return the node you're looking for
	 */
	BinarySearchNode search(int key) {
		// if there is a left child and the data you're looking for should be on the
		// left
		if (leftChild != null && Integer.compare(key, person.key) < 0) {
			return leftChild.search(key);
		}
		// if the right child is null and the data you're looking for should be on the
		// right
		else if (rightChild != null && Integer.compare(key, person.key) > 0) {
			return rightChild.search(key);
		}
		// if you have found the thing- return the thing
		else if (this.person.key == key) {
			return this;
		}
		// if the data is not in the tree return null
		else {
			return null;
		}
	}

	/**
	 * Delete a node from the tree
	 * 
	 * @param key : the key of the node to delete
	 * @return the person data in the node you've deleted
	 */
	Person delete(int key) {
		// first find the node
		BinarySearchNode node = search(key);
		if (node == null)
			return null;
		Person deleted = node.person;

		// if the node has no children delete it by moving the parent
		if (node.leftChild == null && node.rightChild == null) {
			if (node.parent.leftChild == node)
				node.parent.setLeftChild(null);
			else if (node.parent.rightChild == node)
				node.parent.setRightChild(null);
		}
		// if the node has two children, move around some nodes to delete
		else if (node.leftChild != null && node.rightChild != null) {
			BinarySearchNode min = node.rightChild.getNodeWithMinValue();
			node.person = min.person;
			int minKey = min.person.key;
			min.delete(minKey);
		}
		// if the node has a left child - set new nodes to delete
		else if (node.parent.leftChild == node) {
			BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setLeftChild(newLeftChild);
		}
		// if the node has a right child - set new nodes to delete
		else if (node.parent.rightChild == node) {
			BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
			node.parent.setRightChild(newRightChild);
		}

		return deleted;
	}

	/**
	 * Find the left most child of the tree
	 * 
	 * @return the left most child of the tree
	 */
	BinarySearchNode getNodeWithMinValue() {
		if (leftChild == null)
			return this;
		else
			return leftChild.getNodeWithMinValue();
	}

	/**
	 * Set a node's left child
	 * 
	 * @param child the node to be added
	 */
	void setLeftChild(BinarySearchNode child) {
		this.leftChild = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * Set a node's right child
	 * 
	 * @param child : the node to be added
	 */
	void setRightChild(BinarySearchNode child) {
		this.rightChild = child;
		if (child != null)
			child.parent = this;
	}

	/**
	 * The String representation- recursive to print all nodes in the tree in ORDER
	 */
	public String toString() {
		String toReturn = "";

		// recursively print the tree
		if (this.leftChild != null) {
			toReturn += this.leftChild.toString();
		}

		toReturn += "  " + person.toString() + "\n";

		if (this.rightChild != null) {
			toReturn += this.rightChild.toString();
		}

		return toReturn;
	}

}