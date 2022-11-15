package weblab;

class Solution {

    /**
     * Calculates the result of the multiplication between two given values
     * recursively and using arithmetic operators other than multiplication.
     * @param num1 first given value
     * @param num2 second given value
     * @return the multiplication of the two values
     */
    static int multiply(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        if (num1 > 0 && num2 > 0) return multiplyHelp(num1, num2);
        if (num1 > 0 && num2 < 0) return -multiplyHelp(num1, -num2);
        if (num1 < 0 && num2 > 0) return -multiplyHelp(-num1, num2);
        else return multiplyHelp(-num1, -num2);
    }
    static int multiplyHelp(int num1, int num2) {
        if (num2 == 0) return 0;
        return num1 + multiplyHelp(num1, num2 - 1);
    }
}
