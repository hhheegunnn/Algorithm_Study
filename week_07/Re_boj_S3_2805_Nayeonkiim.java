package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S3_2805_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());  //나무의 수
		int M = Integer.parseInt(st.nextToken());  //최소 필요한 나무의 길이
		
		long[] arr = new long[N];
		long right = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i < N; i++) {
			// 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0
			arr[i] = Long.parseLong(st.nextToken());  
			right = Math.max(arr[i], right);
		}
		
		long left = 1;
		long ans = 0;
		while(left <= right) {
			long mid = (left+right)/2;
			long count = calc(arr,mid);
			
			if(count < M) {
				right = mid-1;
			}else {
				if(ans < mid) {
					ans = mid;
				}
				left = mid+1;
			}
		}
		System.out.println(ans);
	}

	private static long calc(long[] arr, long mid) {
		long count = 0;
		for(long a : arr) {
			if(a-mid > 0) {
				count += a-mid;
			}
		}
		return count;
	}
}
