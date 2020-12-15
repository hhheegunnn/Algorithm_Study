package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S3_1463_Nayeonkiim {
	public static int[] d;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[N+1];
		System.out.println(calc(N));
	}
	
	private static int calc(int n) {
		
		if(n==1) return 0;
		if(d[n] > 0) return d[n];
		
		d[n] = calc(n-1) + 1;
		
		if(n%2 == 0 && d[n] > d[n/2]+1) {
			d[n] = d[n/2] + 1;
		}
		if(n%3 == 0 && d[n] > d[n/3]+1) {
			d[n] = d[n/3] + 1;
		}
		return d[n];
	}
}
