package weblab;

class Solution {

    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree
     *     the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static boolean isTreeBalanced(BinaryTree tree) {
        if (tree == null) return true;
        return check(tree) != -1;
    }

    public static int check(BinaryTree t) {
        // if we are call by a leaf we return 0
        if (t == null) return 0;
        
        // get left and right height
        int lh = check(t.getLeft());
        int rh = check(t.getRight());

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
