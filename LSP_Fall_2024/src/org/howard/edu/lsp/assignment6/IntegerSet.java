// File: IntegerSet.java
package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * This class provides methods to perform standard set operations on a collection of integers.
 * It uses an ArrayList to store the elements of the set.
 */
public class IntegerSet {
    // Store the set elements in a List.
    private final List<Integer> set;

    // Default Constructor
    /**
     * Default constructor that creates an empty set.
     */
    public IntegerSet() {
        this.set = new ArrayList<>();
    }

    // Constructor to initialize the set with a given ArrayList of integers
    /**
     * Constructor that initializes the set with the provided ArrayList of integers.
     * 
     * @param set an ArrayList of integers to initialize the set.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set); // Defensive copy
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
     * @param b the other IntegerSet to compare with this set.
     * @return true if the sets are equal, false otherwise.
     */
    public boolean equals(IntegerSet b) {
        return set.containsAll(b.set) && b.set.containsAll(set);
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
     * @throws IntegerSetException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty, cannot find largest element.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     * 
     * @return the smallest integer in the set.
     * @throws IntegerSetException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty, cannot find smallest element.");
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
        HashSet<Integer> tempSet = new HashSet<>(set);
        for (int item : intSetb.set) {
            if (tempSet.add(item)) {
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
     * Computes the complement of this set relative to the universal set.
     * 
     * @param universalSet A list of integers representing the universal set.
     * @return A new IntegerSet containing elements in the universal set but not in the current set.
     */
    public IntegerSet complement(List<Integer> universalSet) {
        List<Integer> complementSet = new ArrayList<>();
        for (int item : universalSet) {
            if (!set.contains(item)) {
                complementSet.add(item);
            }
        }
        return new IntegerSet(new ArrayList<>(complementSet));
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
