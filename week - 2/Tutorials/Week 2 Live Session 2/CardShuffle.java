package weblab;

import java.util.*;

class Solution {

    /**
     * Shuffles a deck of cards. This is done by splitting the existing deck into two halves, L1 and L2.
     * The two halves will be merged back together by taking alternating elements from L1 and L2.
     * Where the order is as follows:
     * first element of L1, first element of L2, second element of L1, second element of L2, and so forth.
     *
     * @param deck - the initial list of cards.
     * @return list of shuffled cards.
     */
    public static List<Card> cardShuffle(List<Card> deck) {
        ArrayList<Card> ans = new ArrayList();
        for (int i = 0; i < deck.size()/2; i++) {
            ans.add(deck.get(i));
            ans.add(deck.get(i + deck.size()/2));
        }
        return ans;
    }
}
