package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_S2_1912_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n+1];
		for(int i=1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] d = new int[n+1][2];
		//연속
		d[1][0] = a[1];
		//해당 index부터 시작
		d[1][1] = a[1];
		int ans = a[1];
		
		for(int i=2; i <= n; i++) {
			d[i][1] = a[i];
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]) + a[i];
			
			int cho = Math.max(d[i][1], d[i][0]);
			ans = Math.max(cho,ans);
		}
		System.out.println(ans);
	}
}
