package weblab;

import java.util.*;

/**
 * Iterates lazily over a binary tree in a depth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as its children should be iterated as: 8 ->
 * 4 -> 10.
 */
class BinaryTreeIterator<V> implements Iterator<V> {

    Node<V> pointer;
    /**
     * Constructor.
     * Should reset on a new tree.
     *
     * @param tree
     *     takes the tree
     */
    public BinaryTreeIterator(BinaryTree<V> tree) {
        pointer = tree.getRoot();
    }

    /**
     * Indicates whether the iterator has more elements to return.
     *
     * @return True if there is a next element in the iterator, else false
     */
    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     *
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public V next() {
        if (pointer == null) return null;
        V value = pointer.getValue();
        if (pointer.getLeft() != null) {
            pointer = pointer.getLeft();
            return value;
        } else if (pointer.getRight() != null) {
            pointer = pointer.getRight();
            return value;
        } 
        while (pointer.getParent() != null) {
            Node dad = pointer.getParent();
            if (dad.getRight() != null
                && dad.getRight() != pointer) {
                pointer = dad.getRight();
                return value;
            }
            pointer = pointer.getParent();
        }
        if (pointer.getParent() == null) {
            pointer = null;
            return value;
        }
        return value;
    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        if (hasNext()) next();
    }
}
