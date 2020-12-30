package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_S3_11726_Nayeonkiim {

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] d = new int[N+1];
		d[1] =1;
		d[2] =2;
		
		for(int i=3; i <= N; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %= 10007;
 		}
		System.out.println(d[N]%10007);
	}

}
