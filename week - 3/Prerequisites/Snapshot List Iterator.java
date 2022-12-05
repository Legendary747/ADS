package weblab;

import java.util.*;

class SnapshotListIterator<V> implements Iterator<V> {

    // Modify this copied list to implement your iterator
    private List<V> copy;
    int pointer;
    /**
     * Creates a copy of the argument to iterate over.
     *
     * @param input the list to iterate over
     */
    public SnapshotListIterator(List<V> input) {
        this.copy = new ArrayList<>(input);
        this.pointer = 0;
    }

    /**
     * Returns whether the iterator has another value it can return.
     *
     * @return true if there is another element to return, false otherwise
     */
    @Override
    public boolean hasNext() {
        return !(pointer >= copy.size());
    }

    /**
     * Returns the next element in the list.
     *
     * @return the next element
     * @throws NoSuchElementException if there is no next element
     */
    @Override
    public V next() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException();
        V curV = copy.get(pointer++);
        return curV;
    }

    /**
     * Skips over the element that would have been returned next.
     * @throws NoSuchElementException if there are no elements to iterate over left
     */
    @Override
    public void remove() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException();
        pointer++;
    }
}
