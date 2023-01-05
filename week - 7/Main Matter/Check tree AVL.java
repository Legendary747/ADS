package weblab;

class Solution {

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        if (tree == null) return true;
        boolean v = checkValue(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int h = checkHeight(tree);
        return h != -1 && v;
    }

    public static boolean checkValue(BinaryTree t, int l, int r) {
        if (t == null) return true;
        // note the question description
        // "...without duplicate values..."
        // so we need to have equals sign in the if statement
        if (t.getKey() <= l || t.getKey() >= r) return false;
        if (!checkValue(t.getLeft(), l, t.getKey())) return false;
        if (!checkValue(t.getRight(), t.getKey(), r)) return false;
        return true;
    }

    public static int checkHeight(BinaryTree t) {
        // if we are call by a leaf we return 0
        if (t == null) return 0;
        
        // get left and right height
        int lh = checkHeight(t.getLeft());
        int rh = checkHeight(t.getRight());

        // if any subtree is invalid entire tree is invalid
        if (lh == -1 || rh == -1) return -1;
        // if current subtree is invalid entire tree is invalid
        if (Math.abs(lh - rh) > 1) return -1;
        // return the max of subtree plus current level
        // because the deepest height is dominant, that is why
        // I use math max
        return (Math.max(lh, rh) + 1);
    }


}
