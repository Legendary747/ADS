package weblab;

class Solution {

    /**
     * Evaluates the arithmetic expression stored in this binary tree.
     *
     * @param node - the root of the arithmetic tree
     * @return the value of the arithmetic tree after evaluation
     * @throws IllegalArgumentException - Whenever node value is not valid (+, -, *)
     */
    @SuppressWarnings("rawtypes")
    public static int eval(Node node) throws IllegalArgumentException {
        if (node == null) throw new IllegalArgumentException();
        int left;
        int right;
        if (!node.isLeaf()) {
            InternalNode inode = (InternalNode) node;
            left = eval(inode.getLeft());
            right = eval(inode.getRight());
            switch(inode.getVal()){
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                default:
                    throw new IllegalArgumentException();     
            }
        } else {
            return (Integer) node.getVal();
        }
    }
}
