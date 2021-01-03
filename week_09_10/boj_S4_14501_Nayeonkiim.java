package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_S4_14501_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] d= new int[N+1];
		for(int i=1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());  //몇일
			P[i] = Integer.parseInt(st.nextToken());  //가격
		}
		
		for(int i=1; i <= N; i++) {
			if(i+T[i] <= N+1) {
				d[i] = P[i];
			}
		}
		
		for(int i=1; i <= N; i++) {
			for(int j=1; j < i; j++) {
				if(i >= j+T[j] && i+T[i] <= N+1 && d[i] < d[j]+P[i]) {
					d[i] = d[j]+P[i];
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i <= N; i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
	}
}
