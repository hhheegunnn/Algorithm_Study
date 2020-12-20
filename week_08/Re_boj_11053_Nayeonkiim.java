package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_boj_11053_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a= new int[N];
		String[] str = br.readLine().split(" ");
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		int[] d= new int[N];
		for(int i=0; i < N; i++) {
			d[i] = 1;
			for(int j=0; j < i; j++) {
				if(a[j] < a[i] && d[i] < d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i < N; i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
	}
}
