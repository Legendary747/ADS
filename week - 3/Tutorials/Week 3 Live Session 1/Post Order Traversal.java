package weblab;

import java.util.*;

class Solution {
    /**
     * Collects all keys in the given binary tree in post-order.
     * Returns a list with all keys in the order they they were found by post-order traversal.
     * Should return an empty list of keys in case the given tree is null.
     *
     * @param tree the input BinaryTree to be traversed
     * @return a list of all keys in the tree as found by post-order traversal
     */
    public static List<Integer> postOrder(BinaryTree tree) {
        if (tree == null) return new ArrayList();
        ArrayList<Integer> keys = new ArrayList();
        if (tree.hasLeft()) keys.addAll(postOrder(tree.getLeft()));
        if (tree.hasRight()) keys.addAll(postOrder(tree.getRight()));
        keys.add(tree.getKey());
        return keys;
    }
}
