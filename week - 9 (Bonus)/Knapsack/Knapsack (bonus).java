import java.util.*;
import java.util.stream.Collectors;

class Solution {
  /**
   * Calculates the most optimal set of items that should be put in the knapsack using backtracking.
   *
   * @param items
   *     The items that you can choose from.
   * @param budget
   *     The maximum weight that the knapsack can carry.
   * @return The optimal set of items that should be put in the knapsack.
   */
  public static Set<Item> knapsack(Set<Item> items, int budget) {
    if (budget <= 0 || items == null) return new HashSet<Item>();
    int amount = items.size();
    int[][] dp = new int[amount+1][budget+1];
    for (int i = 0; i <= amount; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= budget; i++) {
      dp[0][i] = 0;
    }
    List<Item> itemList = items.stream().collect(Collectors.toList());
    itemList.add(0, null);
    for (int i = 1; i <= amount; i++) {
      int curWeight = itemList.get(i).getWeight();
      int curValue = itemList.get(i).getValue();
      for (int j = 1; j <= budget; j++) {
        if (curWeight > j) {
          dp[i][j] = dp[i-1][j];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], curValue + dp[i-1][j-curWeight]);
        }
      }
    }
    Set<Item> ans = new HashSet<Item>();
    int loopVar = budget;
    for (int i = amount; i > 0 && loopVar > 0;) {
      if (dp[i][loopVar] == dp[i-1][loopVar]) {
        i--;
      } else {
        ans.add(itemList.get(i));
        loopVar -= itemList.get(i).getWeight();
        i--;
      }
    }
    return ans;
  }
}

