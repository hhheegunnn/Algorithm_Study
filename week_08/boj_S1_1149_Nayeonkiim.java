package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_S1_1149_Nayeonkiim {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] color = new int[N+1][3];
		for(int i=1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] d = new int[N+1][3];
		d[1][0] = color[1][0];
		d[1][1] = color[1][1];
		d[1][2] = color[1][2];
		
		for(int i=2; i <= N; i++) {
			d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + color[i][0];
			d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + color[i][1];
			d[i][2] = Math.min(d[i-1][1],d[i-1][0]) + color[i][2];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i < 3; i++) {
			if(ans > d[N][i])
				ans = d[N][i];
		}
		System.out.println(ans);
	}

}
