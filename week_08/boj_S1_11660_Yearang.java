import java.util.Scanner;

public class boj_S1_11660_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nmatrix = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                nmatrix[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                nmatrix[i][j] += nmatrix[i-1][j] + nmatrix[i][j-1] - nmatrix[i-1][j-1];
            }
        }

        for(int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int answer = nmatrix[x2][y2] - nmatrix[x1-1][y2] - nmatrix[x2][y1-1] + nmatrix[x1-1][y1-1];
            System.out.println(answer);
        }




    }
}
