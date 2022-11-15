package weblab;

class Solution {

    /**
     * Computes the nth number in the Fibonacci sequence.
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n < 0) return -69;
        if (n == 0 || n == 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
