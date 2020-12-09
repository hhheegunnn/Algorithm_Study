package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_S1_2110_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);
		
		int left = 1, right = arr[arr.length-1], ans = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			int count = calc(mid,arr);
			if(count < C) {
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

	private static int calc(int mid, int[] arr) {
		int count = 1;
		int first = arr[0];
		for(int i=1; i < arr.length; i++) {
			if(arr[i]-first >= mid) {
				count++;
				first = arr[i];
			}
		}
		return count;
	}	
}
