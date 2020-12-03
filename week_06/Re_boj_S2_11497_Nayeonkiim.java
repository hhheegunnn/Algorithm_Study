package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Re_boj_S2_11497_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String[] str = br.readLine().split(" ");
			for(int j=0; j < N; j++) {
				arr[j] = Integer.parseInt(str[j]); 
			}
			
			Arrays.sort(arr);
			
			int[] ans = new int[N];
			int k = 0;
			int ind =N-1;
			for(int j=0; j < N; j+=2) {
				ans[k++] = arr[j];
			}
			for(int j=1; j < N; j+=2) {
				ans[ind] = arr[j];
				ind--;
			}
			
			int answer = 0;
			for(int j=1; j < N; j++) {
				answer = Math.max(Math.abs(ans[j] - ans[j-1]), answer);
			}
			System.out.println(answer);
		}
	}
}
