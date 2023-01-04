package weblab;

import java.util.*;

class Solution {

    /**
     * Traverses the tree in breadth first search (BFS) order.
     * Returns a list containing the keys of all nodes in BFS order.
     * Should return an empty list in case the tree is null.
     *
     * @param tree - the tree that will be traversed
     * @return list containing the keys of each node in the correct order
     */
    public static List<Integer> bfs(Tree tree) {
        if (tree == null) return null;
        LinkedList<Tree> trees = new LinkedList();
        trees.addFirst(tree);
        ArrayList<Integer> ans = new ArrayList();
        while (trees.size() != 0) {
            Tree cur = trees.removeFirst();
            for (Tree t : cur.getChildren()) trees.add(t);
            ans.add(cur.getKey());
        }
        return ans;
    }
}
