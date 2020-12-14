package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S5_1010_Nayeonkiim {

	static long[][] d = new long[31][31];
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=1; i<31; i++) {
			d[1][i] = i;
		}
		
		for(int i=2; i < 31; i++) {
			for(int j=i; j < 31; j++) {
				if(i==j) {
					d[i][j] = 1;
				}
				else if(j-i == 1) {
					d[i][j] = d[i-1][j-1]+d[i-1][j-2];
				}
				else {
					//한 개를 뺀 나머지 모든 경우를 남는 점 갯수 = 연결점 갯수일  때까지 더해버리면 됨.
					for(int t=j-1; t > i-2; t--) {
						d[i][j] += d[i-1][t];
					}
				}
			}
		}
		
		for(int i=0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(d[a][b]);
		}
	}
}
