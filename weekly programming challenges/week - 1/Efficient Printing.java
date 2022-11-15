import java.io.*;
import java.util.*;

class Solution {

  public static void run(InputStream in, PrintStream out) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
    new Solution().solve(sc, out);
    sc.close();
  }

  public void solve(Scanner sc, PrintStream out) {
    // 十年OI一场空 不开longlong见祖宗～
    long n = Long.parseLong(sc.nextLine());
    long ans = 0;
    while (n >= 5) {
      ans += n / 5;
      n /= 5;
    }
    out.println(ans);
    out.close();
  }
}
