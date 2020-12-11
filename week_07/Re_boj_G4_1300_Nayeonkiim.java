package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_boj_G4_1300_Nayeonkiim {
	
	private static long n;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());

		long left = 1;
		long right = n * n;
		long ans = 1;
		while(left <= right) {
			long mid = (left+right) / 2;
			
			if(calc(mid) >= k) {
				ans = mid;
				right = mid-1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
		
	}
	
	// 8을 1부터  n까지 각 행으로 나누었을 때의 몫이 그 행에서 8 보다 작거나 같은 수의 갯수가 됨.
	private static long calc(long mid) {
		long cnt = 0;
		for(long i=1; i <= n ; i++) {
			cnt += Math.min(n,mid/i);
		}
		return cnt;
	}
}
