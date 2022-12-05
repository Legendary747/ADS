package weblab;

import java.util.*;

class Solution {

    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTree tree) {
        if (tree == null) return true;
        Queue<BinaryTree> q = new LinkedList();
        ArrayList<BinaryTree> parts = new ArrayList();
        q.add(tree);
        while (!q.isEmpty()) {
            BinaryTree t = q.poll();
            parts.add(t);
            if (t.hasLeft()) q.add(t.getLeft());
            if (t.hasRight()) q.add(t.getRight());
        }
        for (int i = 0; i < parts.size(); i++) {
            int leftIndex = i*2 + 1;
            int rightIndex = i*2 + 2;
            if (leftIndex < parts.size() && parts.get(i).getLeft() != parts.get(leftIndex)) return false;
            if (rightIndex < parts.size() && parts.get(i).getRight() != parts.get(rightIndex)) return false;
        }
        return true;
    }
}
