import java.util.Scanner;

public class boj_S3_2579_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stair = new int[n];

        for (int i = 0; i < n; i++) {
            stair[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = stair[0];
        if(n >= 2) {
            dp[1] = stair[0] + stair[1];
        }
        if(n >= 3) {
            dp[2] = stair[2] + Math.max(stair[0], stair[1]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = stair[i] + Math.max(dp[i - 2], stair[i - 1] + dp[i - 3]);
        }
        System.out.println(dp[n - 1]);

    }
}
