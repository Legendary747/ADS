package weblab;

import java.util.*;

class Solution {

    /**
     * Return all elements in the given BST in descending order.
     *
     * @param tree
     *     The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        if (tree == null) return null;
        ArrayList<Integer> ins = new ArrayList();
        if (tree.getRight() != null) ins.addAll(descendingOrder(tree.getRight()));
        ins.add(tree.getKey());
        if (tree.getLeft() != null) ins.addAll(descendingOrder(tree.getLeft()));
        return ins;
    }
}
