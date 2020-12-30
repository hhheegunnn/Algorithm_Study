package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Re_boj_S3_9095_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] d= new int[n+1];
			
			d[1] = 1;
			if(n == 1) {
				System.out.println(d[1]);
				continue;
			}
			d[2] = d[1]+1;
			if(n == 2) {
				System.out.println(d[2]);
				continue;
			}
			d[3] = d[1]+d[2]+1;
			if(n == 3) {
				System.out.println(d[3]);
				continue;
			}
			
			for(int j=4; j <=n; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3]; 
			}
			System.out.println(d[n]);
		}
	}
}
