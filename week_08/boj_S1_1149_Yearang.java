import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_S1_1149_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rgb = new int[n][3];
        for(int i = 0; i < n; i++) {
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }

        int[][] dp = new int[n][3];
        dp[0] = rgb[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = rgb[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int answer = dp[n-1][0];
        for(int i = 0; i < 3; i ++) {
            if( answer > dp[n-1][i]) {
                answer = dp[n-1][i];
            }
        }
        System.out.println(answer);




    }
}
