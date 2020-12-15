import java.util.Scanner;

public class boj_S5_1010_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        // nCr = n-1Cr-1 + n-1Cr

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] combi = new int[m+1][n+1];
            combi[1][0] = 1;
            combi[1][1] = 1;

            for(int j = 2; j <= m; j++) {
                combi[j][0] = 1;
                for(int k = 1; k <= n; k++) {
                    combi[j][k] = combi[j-1][k-1] + combi[j-1][k];
                }
            }
            System.out.println(combi[m][n]);

        }
    }


}
