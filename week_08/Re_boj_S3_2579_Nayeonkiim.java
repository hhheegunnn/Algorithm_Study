package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_boj_S3_2579_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N+1][3];
		
		int[] arr = new int[N];
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		d[1][1] = arr[0]; 
		for (int i=2; i<=N; i++) {
            d[i][2] = d[i-1][1] + arr[i-1];
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + arr[i-1];
        }
        System.out.println(Math.max(d[N][1], d[N][2]));
	}	

}
