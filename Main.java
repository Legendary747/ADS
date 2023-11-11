import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Total money
        int m = sc.nextInt(); // Number of items

        int[][] dp = new int[m + 1][N + 1];
        Item[] items = new Item[m + 1];

        // Initialize all items
        for (int i = 0; i <= m; i++) {
            items[i] = new Item(0, 0, 0);
        }

        for (int i = 1; i <= m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            if (q == 0) {
                // Main item
                items[i].setV(v);
                items[i].setImportance(p * v);
                items[i].setQ(q);
            } else {
                // Attachment
                if (items[q].attachment1 == null) {
                    items[q].attachment1 = new Item(v, p * v, q);
                } else {
                    items[q].attachment2 = new Item(v, p * v, q);
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = dp[i - 1][j]; // Not buying the i-th item

                // Main item without attachments
                if (items[i].q == 0 && j >= items[i].v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v] + items[i].importance);
                }

                // Main item with first attachment
                if (items[i].q == 0 && items[i].attachment1 != null && j >= items[i].v + items[i].attachment1.v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].attachment1.v] + items[i].importance + items[i].attachment1.importance);
                }

                // Main item with second attachment
                if (items[i].q == 0 && items[i].attachment2 != null && j >= items[i].v + items[i].attachment2.v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].attachment2.v] + items[i].importance + items[i].attachment2.importance);
                }


                // Main item with both attachments
                if (items[i].q == 0 && items[i].attachment1 != null && items[i].attachment2 != null && j >= items[i].v + items[i].attachment1.v + items[i].attachment2.v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i].v - items[i].attachment1.v - items[i].attachment2.v] + items[i].importance + items[i].attachment1.importance + items[i].attachment2.importance);
                }
            }
        }

        System.out.println(dp[m][N]);
    }
}

class Item {
    int v; // Price
    int importance; // Price multiplied by importance
    int q; // 0 if main item, otherwise the index of the main item
    Item attachment1; // First attachment
    Item attachment2; // Second attachment

    public Item(int v, int importance, int q) {
        this.v = v;
        this.importance = importance;
        this.q = q;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
