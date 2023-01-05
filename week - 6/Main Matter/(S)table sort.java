package weblab;

class Solution {

    public static void stableSort(String[][] table, int column) {
        // DO insertion
        for (int i = 0; i < table.length; i++) {
            for (int j = i; j > 0; j--) {
                // if current line is lexicographically less than the previous one
                // swap them
                if (table[j][column].compareTo(table[j-1][column]) < 0) {
                    String[] tmp = table[j-1];
                    table[j-1] = table[j];
                    table[j] = tmp;
                }
            }
        }
        // debug print
        // need to comment out for extreme big test set
        // because IO is slow and this will cause TLE on cp questions.
        printa(table);
    }

    public static void printa(String[][] s) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n<[\n");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                sb.append(s[i][j]);
                if (j != s[i].length - 1)sb.append(", ");
            }
            sb.append("\n");
        }
        sb.append("]>");
        System.out.println(sb.toString());
    }
}
