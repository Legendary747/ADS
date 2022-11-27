package weblab;

import java.util.*;

class Queue<T> {

    private LibraryStack<T> s1 = new LibraryStack<>();

    private LibraryStack<T> s2 = new LibraryStack<>();

    /**
     * Returns whether the queue is empty.
     *
     * @return true if there are no elements left, false otherwise.
     */
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        return s1.size();
    }

    /**
     * Adds an element to the queue.
     *
     * @param i element to enqueue.
     */
    public void enqueue(T i) {
        s1.push(i);
    }

    /**
     * Removes the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public T dequeue() throws NoSuchElementException {
        if (s1 == null || s1.isEmpty()) throw new NoSuchElementException();
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        T toReturn = s2.pop();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return toReturn;
    }

    /**
     * Returns the first element from the queue without removing it.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public T first() throws NoSuchElementException {
        if (s1 == null || s1.isEmpty()) throw new NoSuchElementException();
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        T toReturn = s2.pop();
        s2.push(toReturn);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return toReturn;
    }
}
