package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S2_11722_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[N];
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N];
		for(int i=N-1; i >= 0; i--) {
			d[i] = 1;
			for(int j=N-1; j > i; j--) {
				if(a[i] > a[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}
		
		int ans = 0;
		for(int i : d) {
			if(i > ans) {
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
