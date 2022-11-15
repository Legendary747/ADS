package weblab;

// 1.1 Total number of prime numbers 
class Solution {

    /**
     * Checks whether the given integer value is a prime number.
     *
     * @param n integer value to be checked if it is a prime number or not
     * @return returns true if n is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3 ; i <= Math.sqrt(n); i += 2){
            if (n % i == 0) return false;
        } 
        return true;
    }

    /**
     * Counts and returns the number of prime numbers that are less or equal
     * than the given integer value.
     *
     * @param n integer value defining an upper bound on the set of prime number to count
     * @return returns the number of prime numbers that are less or equal than n
     */
    public static int numPrimes(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++){   
            if (isPrime(i)) {
                System.out.println(i);
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
