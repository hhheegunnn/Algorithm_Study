package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S1_1932_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] a = new int[n+1][n+1];
		
		for(int i=1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j <= i ; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//0 은 왼쪽대각선, 1은 오른쪽 대각선
		int[][] d = new int[n+1][n+1];
		int start = 1;
		d[1][1] = a[1][1];
		for(int i=2; i <= n; i++) {
			for(int j=1; j <= i ; j++) {
				if(j == 1)
					d[i][1] = d[i-1][1] + a[i][1];
				else if(j == i) {
					d[i][j] = d[i-1][j-1] + a[i][j];
				}else {
					int ans = 0, count = 0;
					for(int k=start; k < i; k++) {
						//위의 2개와 비교
						if(count == 2) {
							start-=1;
							break;
						}
						if(d[i-1][k] > ans) {
							ans = d[i-1][k];
						}
						start++;
						count++;
					}
					d[i][j] = ans + a[i][j];
				}
 			}
			start = 1;
		}

		int answer = 0;
		for(int k=1; k <= n; k++) {
			if(answer < d[n][k]) {
				answer = d[n][k];
			}
		}
		System.out.println(answer);
	}
}
