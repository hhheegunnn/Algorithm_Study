import java.util.Scanner;

public class boj_S2_11053_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int answer = 1;
        for(int i = 1; i < n; i++) {
            int maxj = -1;
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && max < dp[j]) {
                    maxj = j;
                    max = dp[j];
                }
            }
            if( maxj == -1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[maxj] + 1;
            }
            answer = answer < dp[i] ? dp[i] : answer;
        }
        System.out.println(answer);
    }
}
