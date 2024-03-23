package org.example;

import java.util.Comparator;

/**
 * An ordered collection of elements that allows duplicate elements
 * and provides a way to access elements by their index.
 *
 * @param <E> the type of elements in this list
 * @see ArrayList
 */
public interface List<E> {

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    void add(E element);

    /**
     * Inserts an element at a specified index in the list.
     *
     * @param index   the index at which to insert the element
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void add(int index, E element);

    /**
     * Retrieves the element at a specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    E get(int index);

    /**
     * Removes the element at a specified index from the list.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void remove(int index);

    /**
     * Clears all elements from the list.
     */
    void clear();

    /**
     * Replaces the element at a specified index with a new element.
     *
     * @param index   the index of the element to replace
     * @param element the new element to replace with
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void replace(int index, E element);

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();

    /**
     * Sorts the elements in the list using a specified comparator.
     *
     * @param c the comparator to use for sorting
     */
    void sort(Comparator<? super E> c);
}
