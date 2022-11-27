package weblab;

class ArrayStack {

    private Object[] elements;

    private int size;

    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStack() {
        this.elements = new Object[1];
        this.capacity = elements.length;
        this.size = 0;
        // TODO
    }

    /**
     * Returns the size of this ArrayStack.
     * @return The size of this ArrayStack.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the ArrayStack is empty.
     * @return true if this ArrayStack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns whether the ArrayStack is full.
     * @return true if the size is equal to the capacity, false otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element of the stack.
     */
    public Object peek() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        return elements[capacity - 1];
    }

    /**
     * Adds 'o' to the stack.
     * If capacity of stack was too small, capacity is doubled and 'o' is added.
     *
     * @param o the element to add to the stack.
     */
    public void push(Object o) {
        if (!isFull()){
            elements[size] = o;
        } else {
            Object[] bigger = new Object[2 * capacity];
            for (int i = 0; i < elements.length; i++) {
                bigger[i] = elements[i];
            }
            this.capacity = bigger.length;
            bigger[size] = o;
            this.elements = bigger;
        }
        size++;
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException
     *     iff the stack is empty
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        size--;
        Object toReturn = elements[size];
        elements[size] = null;
        if ((double) size / elements.length < 0.25) {
            int newSize = elements.length / 2 >= 1 ? elements.length / 2 : 1;
            Object[] smaller = new Object[newSize];
            for (int i = 0; i < smaller.length; i++) {
                smaller[i] = elements[i];
            }
            this.elements = smaller;
            this.capacity = newSize;
        }
        return toReturn;
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        String s = "<ArrayStack[";
        for (int i = 0; i < size; i++) {
            if (i != size - 1) s += elements[i] + ",";
            else s += elements[i];
        }
        s += "]>(Size=" + size + ", Cap=" + capacity + ")";
        return s;
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}
