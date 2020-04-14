package edu.unl.raikes.BinarySearchTreeLab;

public class LabRunner {

	/**
	 * Executes the program. Adds/searches/removes from a BST.
	 * 
	 * @param args this program accepts no args.
	 */
	public static void main(String[] args) {
		// create the tree
		BinarySearchTree bst = new BinarySearchTree();

		// add Dr. Val to the tree
		insertIntoBSTAndPrintResults(bst, new Person(555555555, "Dr. Val"));

		// add Dr. Cooper to the tree
		insertIntoBSTAndPrintResults(bst, new Person(222222222, "Dr. Cooper"));

		// insert an already existing key
		insertIntoBSTAndPrintResults(bst, new Person(555555555, "Anna K"));

		// add Anna to the tree
		insertIntoBSTAndPrintResults(bst, new Person(111111111, "Anna"));

		// add Mark to the tree
		insertIntoBSTAndPrintResults(bst, new Person(333333333, "Mark"));

		// add Kylie to the tree
		insertIntoBSTAndPrintResults(bst, new Person(777777777, "Kylie"));

		// add Connor to the tree
		insertIntoBSTAndPrintResults(bst, new Person(666666666, "Connor"));

		// find the person with NUID 111111111
		searchInBSTAndPrintResults(bst, 111111111);

		// find the person with NUID 555555555
		searchInBSTAndPrintResults(bst, 555555555);

		// search for something that doesnt exist
		searchInBSTAndPrintResults(bst, 8675309);

		// delete the person with NUID 555555555
		deleteFromBSTAndPrintResults(bst, 555555555);

		// delete the person with NUID 222222222
		deleteFromBSTAndPrintResults(bst, 222222222);

		// delete element that does not exist
		deleteFromBSTAndPrintResults(bst, 8675309);

		// delete the person with NUID 333333333
		deleteFromBSTAndPrintResults(bst, 333333333);

		// delete the person with NUID 111111111
		deleteFromBSTAndPrintResults(bst, 111111111);

		// delete the person with NUID 777777777
		deleteFromBSTAndPrintResults(bst, 777777777);

		// delete the person with NUID 666666666
		deleteFromBSTAndPrintResults(bst, 666666666);

	}

	/**
	 * Inserts a person into a BST and prints the results
	 * 
	 * @param bst    the BST to insert a person into
	 * @param person the person to insert into a BST
	 */
	private static void insertIntoBSTAndPrintResults(BinarySearchTree bst, Person person) {
		// insert the person
		bst.insert(person);
		// print the results
		System.out.println("Attempted to insert a person with NUID " + person.key + ": ");
		System.out.println("  " + person);
		System.out.println(bst);
	}

	/**
	 * Searches for a person based on a key in a BST and prints the results
	 * 
	 * @param bst the BST that might contain the person
	 * @param key the key that uniquely identifies a person
	 */
	private static void searchInBSTAndPrintResults(BinarySearchTree bst, int key) {
		// find the person with NUID key
		Person found = bst.search(key);
		// print the results
		System.out.println("Found the person with NUID " + key + ": ");
		if (found == null) {
			System.out.println("Person does not exist");
		} else {
			System.out.println("  " + found);
			System.out.println(bst);
		}
	}

	/**
	 * Deletes a person based on a key from the BST and prints the results
	 * 
	 * @param bst the BST from which to delete the person
	 * @param key the key that uniquely identifies a person
	 */
	private static void deleteFromBSTAndPrintResults(BinarySearchTree bst, int key) {
		// delete the person with NUID key
		Person deleted = bst.delete(key);
		// print the results
		System.out.println("Deleted the person with NUID " + key + ": ");
		if (deleted == null) {
			System.out.println("Person does not exist");
			System.out.println("");
		} else {
			System.out.println(" " + deleted);
			System.out.println(bst);
		}
	}
}
