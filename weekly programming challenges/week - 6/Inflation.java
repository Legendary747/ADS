import java.io.*;
import java.util.*;

class Solution {

  public static void run(InputStream in, PrintStream out) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
    new Solution().solve(sc, out);
    sc.close();
  }

  public void solve(Scanner sc, PrintStream out) {
   int size = Integer.parseInt(sc.nextLine());
        int[] gas_arr = new int[size];
        int[] b_arr = new int[size];
        boolean b = false;

        for(int i = 0;i<size;i++){
            gas_arr[i] = sc.nextInt();
            b_arr[i] = i+1;
        }

        Arrays.sort(gas_arr);

        double fracton = Integer.MAX_VALUE;
        double frac2 = Integer.MAX_VALUE;

        for(int j =0;j<size;j++){
            if(gas_arr[j] > b_arr[j]){
                b = true;
                break;
            }else{
                frac2 = (double) gas_arr[j]/b_arr[j];
                if(frac2 < fracton) fracton = frac2;
            }
        }

        if(b) out.println("impossible");
        else out.println(fracton);
  }
}

