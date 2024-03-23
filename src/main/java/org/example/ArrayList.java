package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Resizable-array implementation of the {@code List} interface
 *
 * @param <E> the type of elements in the list
 */
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    /**
     * Constructs a new ArrayList with a default capacity of 10.
     */
    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    @Override
    public void add(E element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = element;
    }

    /**
     * Inserts an element at a specified index in the list.
     *
     * @param index   the index at which to insert the element
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Retrieves the element at a specified index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    /**
     * Removes the element at a specified index from the list.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    /**
     * Clears all elements from the list.
     */
    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    /**
     * Replaces the element at a specified index with a new element.
     *
     * @param index   the index of the element to replace
     * @param element the new element to replace with
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void replace(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sorts the elements in the list using a specified comparator. Uses the quick sorting algorithm.
     *
     * @param c the comparator to use for sorting
     */
    @Override
    public void sort(Comparator<? super E> c) {
        quicksort(0, size - 1, c);
    }

    private void quicksort(int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pi = partition(low, high, c);
            quicksort(low, pi - 1, c);
            quicksort(pi + 1, high, c);
        }
    }

    private int partition(int low, int high, Comparator<? super E> c) {
        E pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (c.compare(get(j), pivot) <= 0) {
                i++;
                E temp = get(i);
                array[i] = array[j];
                array[j] = temp;
            }
        }
        E temp = get(i + 1);
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

}