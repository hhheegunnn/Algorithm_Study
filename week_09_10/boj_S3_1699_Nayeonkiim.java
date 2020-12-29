package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S3_1699_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N+1];
		for(int i=1; i <= N; i++) {
			d[i] = i;
			for(int k=1; k*k <= i; k++) {
				if(d[i] > d[i-k*k] + 1) {
					d[i] = d[i-k*k] + 1;
				}
			}
		}
		System.out.println(d[N]);
	}

}
