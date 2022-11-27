package weblab;

class Solution {

    /**
     * Clones the given two-dimensional array (makes a deep copy).
     *
     * @param a array to copy.
     * @return a deep copy of the array.
     */
    static double[][] clone(double[][] a) {
        if(a == null) return a;
        if(a.length == 0) return new double[0][0];
        double[][] b;
        b = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }
}
