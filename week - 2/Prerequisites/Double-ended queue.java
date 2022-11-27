package weblab;

/**
 * Implementation of a double ended queue.
 *
 * @param <T>
 *     Type of elements the queue can hold
 */
class Deque<T> {

    /**
     * Position-based list to keep the elements of the queue
     */
    private final CLList<T> list;

    /**
     * Constructs a new queue.
     * Chooses a circular linked list as an implementation of a position-based list.
     */
    public Deque() {
        this.list = new CLList<>();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size() {
        return list.size();
    }

    /**
     * Return whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws EmptyDequeException
     *     iff the queue is empty
     */
    public T getFirst() throws EmptyDequeException {
        if(list == null || list.getFirst() == null || isEmpty()) {
            throw new EmptyDequeException();
        }
        return list.getFirst().getElement();
    }

    /**
     * Returns the element at the end of the queue without removing it.
     *
     * @return the element at the end of the queue
     * @throws EmptyDequeException
     *     iff the queue is empty
     */
    public T getLast() throws EmptyDequeException {
        if(list == null || list.getLast() == null || isEmpty()){
            throw new EmptyDequeException();
        }
        return list.getLast().getElement();
    }

    /**
     * Adds an element to the front of the queue.
     *
     * @param element to add.
     */
    public void addFirst(T element) {
        //CNode first = new CNode(element, list.getFirst());
        list.addFirst(element);
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element to add.
     */
    public void addLast(T element) {
        //CNode last = new CNode(list.getLast().getElement(), element);
        list.addLast(element);
    }

    /**
     * Removes and return the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws EmptyDequeException
     *     iff the queue is empty
     */
    public T removeFirst() throws EmptyDequeException {
        CNode first = list.getFirst();
        if (first == null) throw new EmptyDequeException();
        list.remove(first);
        return (T) first.getElement();
    }

    /**
     * Removes and return the element at the end of the queue.
     *
     * @return the element at the end of the queue
     * @throws EmptyDequeException
     *     iff the queue is empty
     */
    public T removeLast() throws EmptyDequeException {
        CNode last = list.getLast();
        if (last == null) throw new EmptyDequeException();
        list.remove(last);
        return (T) last.getElement();
    }
}
