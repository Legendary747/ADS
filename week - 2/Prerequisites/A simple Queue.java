package weblab;

import java.util.LinkedList;

class Queue<T> {

    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Adds an element to the front of the queue.
     *
     * @param element
     *     to add.
     */
    public void enqueue(T element) {
        if (element == null) return;
        list.addLast(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the dequeue
     * @throws EmptyQueueException
     *     iff the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.remove();
    }
}
