package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_S5_1789_Nayeonkiim {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(bf.readLine());
		
		long total = 0;
		long left = 1, right = Integer.MAX_VALUE;
		
		while(left <= right) {
			long mid = (left+right)/2;
			if(calc(mid,S)) {
				if(total < mid) {
					total = mid;
				}
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(total);
	}

	private static boolean calc(long mid, long S) {
		long total = 0;
		for(int i=1; i <= mid; i++) {
			total += i;
			if(total > S) {
				return false;
			}
		}
		return true;
	}
}
