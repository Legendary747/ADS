import java.io.*;
import java.util.*;

class Solution {

  public static void run(InputStream in, PrintStream out) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
    new Solution().solve(sc, out);
    sc.close();
  }

  public void solve(Scanner sc, PrintStream out) {
    if (n(sc.nextInt()) == 1) out.println("yes");
    else out.println("no");
  }

  public int n(int n) {
    if (n <= 1) return 0;
    if (n == 2) return 1;
    if (n%2 == 0) return 0;
    for (int i = 3; i < Math.floor(Math.sqrt(n));i++) {
      if (n%i == 0) return 0;
    }
    return 1;
  }
}
