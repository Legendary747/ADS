package weblab;

class SLList {

    class Node {

        // Each node object has these two fields
        private Object element;

        private Node next;

        /**
         * Creates a Node object with element = e and next = n
         * @param e Element for the node.
         * @param n Next node.
         */
        Node(Object e, Node n) {
            element = e;
            next = n;
        }

        /**
         * Sets the element to the given parameter.
         * @param e The new element for this node.
         */
        public void setElement(Object e) {
            element = e;
        }

        /**
         * Returns the element of this node.
         * @return The element of this node.
         */
        public Object getElement() {
            return element;
        }

        /**
         * Sets the next pointer to the given node.
         * @param n Node to make next point to.
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Returns the next node.
         * @return The next node.
         */
        public Node getNext() {
            return next;
        }
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    /**
     * @return The element in the head Node of the SLL
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        Node newNode = new Node(e, head);
        head = newNode;
    }

    /**
     * Removes the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        Node oldHead = head;
        if (oldHead == null) return null;
        head = head.getNext();
        return oldHead.getElement();
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {
        Node loop = head;
        if (loop == null) {
            Node newNode = new Node(e, null);
            head = newNode;
            return;
        }
        while (loop.getNext() != null) loop = loop.getNext();
        Node newNode = new Node(e, null);
        loop.setNext(newNode);
    }

    /**
     * Removes the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null) return null;
        if (head.getNext() == null) {
            Object e = head.getElement();
            head = null;
            return e;
        }
        Node loop = head;
        Node before = head;

        while (loop.getNext() != null) {
            before = loop;
            loop = loop.getNext();
        }
        
        before.setNext(null);
        return loop.getElement();
    }

    /**
     * Removes Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos < 0) return null;
        if (pos == 0) return removeFirst();
        Node loop = head;
        Node before = head;
        while (loop.getNext() != null && pos > 0) {
            before = loop;
            loop = loop.getNext();
            pos--;
        }
        if (pos > 0) return null;
        before.setNext(loop.getNext());
        return loop.getElement();
    }
}
