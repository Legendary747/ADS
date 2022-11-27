package weblab;

class DLList {

    class Node {

        // Each node object has these three fields
        private Object element;

        private Node previous;

        private Node next;

        /**
         * Constructor: Creates a Node object.
         *
         * @param e the element in the Node.
         * @param p the previous Node.
         * @param n the next Node.
         */
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        /**
         * Sets the element of the Node.
         *
         * @param e the new element.
         */
        public void setElement(Object e) {
            element = e;
        }

        /**
         * Returns the element of the Node.
         *
         * @return the element of the Node.
         */
        public Object getElement() {
            return element;
        }

        /**
         * Sets the next Node.
         *
         * @param n the new next Node.
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Returns the next Node.
         *
         * @return the next Node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the previous Node.
         *
         * @param p the new previous Node.
         */
        public void setPrevious(Node p) {
            previous = p;
        }

        /**
         * Returns the previous Node.
         *
         * @return the previous Node.
         */
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;

    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * Returns the element in the head Node.
     *
     * @return The element in the head Node (or null if the list is empty)
     */
    public Object getHead() {
        if (head == null) return null;
        return head.getElement();
    }

    /**
     * Returns the element in the tail Node.
     *
     * @return The element in the tail Node (or null if the list is empty)
     */
    public Object getTail() {
        if (tail == null) return null;
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e the element to add.
     */
    public void addFirst(Object e) {
        // Empty List
        if (head == null && tail == null) {
            Node newNode = new Node(e, null, null);
            head = newNode;
            tail = newNode;
        } else {
        // not empty list
            Node newNode = new Node(e, null, head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        // Empty list
        if (head == null && tail == null) {
            return null;
        } else if (head == tail) {
            Node toReturn = head;
            head = null;
            tail = null;
            return toReturn.getElement();
        } else {
            Node toReturn = head;
            head = head.getNext();
            head.setPrevious(null);
            return toReturn.getElement();
        }
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e the element to add.
     */
    public void addLast(Object e) {
        if (head == null && tail == null) {
            addFirst(e);
        } else {
            Node newNode = new Node(e, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null && tail == null) {
            return removeFirst();
        } else if (head == tail) {
            Node toReturn = head;
            head = null;
            tail = null;
            return toReturn.getElement();
        } else {
            Node toReturn = tail;
            tail = tail.getPrevious();
            tail.setNext(null);
            return toReturn.getElement();
        }
    }

    /**
     * Returns the number of Nodes in the list.
     *
     * @return the number of Nodes in the list.
     */
    public int size() {
        Node begin = head;
        int cnt = 0;
        while (begin != null) {
            cnt++;
            begin = begin.getNext();
        }
        return cnt;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos
     *     The position to insert the element at.
     * @param e
     *     The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (pos == 0) {
            addFirst(e);
            return;
        }
        if (pos >= size()) {
            addLast(e);
            return;
        }
        int cnt = 0;
        Node begin = head;
        while (cnt != pos) {
            cnt++;
            begin = begin.getNext();
        }
        Node newNode = new Node(e, begin.getPrevious(), begin);
        Node prev = begin.getPrevious();
        Node next = begin;
        prev.setNext(newNode);
        next.setPrevious(newNode);
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos
     *     The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos == 0) return removeFirst();
        if (pos >= size()) return null;
        int cnt = 0;
        Node begin = head;
        while (cnt != pos) {
            cnt++;
            begin = begin.getNext();
        }
        Node prev = begin.getPrevious();
        Node next = begin.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        return begin.getElement();
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {
        Node begin = head;
        DLList reverse = new DLList();
        // shallow copy try
        while (begin != null) {
            reverse.addFirst(begin.getElement());
            begin = begin.getNext();
        }
        return reverse;
    }
}

