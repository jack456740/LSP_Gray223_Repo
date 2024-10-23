package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class provides methods to perform standard set operations on a collection of integers.
 * It uses an ArrayList to store the elements of the set.
 */
public class IntegerSet {
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	/**
	 * Default constructor that creates an empty set.
	 */
	public IntegerSet() {
	}

	// Constructor to initialize the set with a given ArrayList of integers
	/**
	 * Constructor that initializes the set with the provided ArrayList of integers.
	 * 
	 * @param set an ArrayList of integers to initialize the set.
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	/**
	 * Clears all elements from the set.
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * Returns the number of elements in the set.
	 * 
	 * @return the number of elements in the set.
	 */
	public int length() {
		return set.size();
	}

	/**
	 * Checks if two sets are equal. Two sets are considered equal if they have the
	 * same elements regardless of the order.
	 * 
	 * @param o an object to compare with this set.
	 * @return true if the sets are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IntegerSet)) {
			return false;
		}
		IntegerSet otherSet = (IntegerSet) o;
		return set.containsAll(otherSet.set) && otherSet.set.containsAll(set);
	}

	/**
	 * Checks if the set contains a specific value.
	 * 
	 * @param value the integer value to check.
	 * @return true if the value is present in the set, false otherwise.
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}

	/**
	 * Returns the largest element in the set.
	 * 
	 * @return the largest integer in the set.
	 * @throws Exception if the set is empty.
	 */
	public int largest() throws Exception {
		if (set.isEmpty()) {
			throw new Exception("Set is empty");
		}
		return Collections.max(set);
	}

	/**
	 * Returns the smallest element in the set.
	 * 
	 * @return the smallest integer in the set.
	 * @throws Exception if the set is empty.
	 */
	public int smallest() throws Exception {
		if (set.isEmpty()) {
			throw new Exception("Set is empty");
		}
		return Collections.min(set);
	}

	/**
	 * Adds an element to the set. If the element already exists, it is not added.
	 * 
	 * @param item the integer to add to the set.
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}

	/**
	 * Removes an element from the set if present. If the element is not present, it
	 * does nothing.
	 * 
	 * @param item the integer to remove from the set.
	 */
	public void remove(int item) {
		set.remove((Integer) item);
	}

	/**
	 * Combines the elements of this set with another set (union operation).
	 * 
	 * @param intSetb the other IntegerSet to union with this set.
	 */
	public void union(IntegerSet intSetb) {
		for (int item : intSetb.set) {
			if (!set.contains(item)) {
				set.add(item);
			}
		}
	}

	/**
	 * Retains only the elements that are present in both this set and another set
	 * (intersection operation).
	 * 
	 * @param intSetb the other IntegerSet to intersect with this set.
	 */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}

	/**
	 * Removes all elements from this set that are present in another set (difference
	 * operation).
	 * 
	 * @param intSetb the other IntegerSet to subtract from this set.
	 */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}

	/**
	 * Returns whether the set is empty or not.
	 * 
	 * @return true if the set is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Returns a string representation of the set.
	 * 
	 * @return a string representing the set elements.
	 */
	@Override
	public String toString() {
		return set.toString();
	}
}
