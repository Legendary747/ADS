package weblab;

class Solution {

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree tree) {
        if (tree == null) return true;
        return check(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // The idea is to check if the value of each node is in the valid range
    // we know the left child < current node value
    // and
    // right child > current node value
    // if this is not the case we return false.
    public static boolean check(BinaryTree t, int l, int r) {
        if (t == null) return true;
        // note the question description
        // "...without duplicate values..."
        // so we need to have equals sign in the if statement
        if (t.getKey() <= l || t.getKey() >= r) return false;
        if (!check(t.getLeft(), l, t.getKey())) return false;
        if (!check(t.getRight(), t.getKey(), r)) return false;
        return true;
    }
}
