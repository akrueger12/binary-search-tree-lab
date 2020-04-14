package edu.unl.raikes.BinarySearchTreeLab;

/**
 * The person class :)
 * 
 * @author anna and devin
 *
 */
public class Person implements Comparable<Person> {
	int key;
	String name;

	/**
	 * The constructor for the person
	 * 
	 * @param NUID : the NUID of the person
	 * @param name : the name of the person
	 */
	Person(int NUID, String name) {
		this.key = NUID;
		this.name = name;
	}

	/**
	 * The printable version of the person
	 */
	public String toString() {
		return "NUID: " + this.key + "  Name: " + name;
	}

	/**
	 * Compares the people by keys
	 */
	public int compareTo(Person other) {
		return Integer.compare(key, other.key);
	}
}
