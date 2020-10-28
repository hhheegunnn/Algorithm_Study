package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Ai는 Ai-1의 배수라는 조건 때문에 그리디 알고리즘 (배수가 아닐 경우 다이나믹으로 풀어야 함)*/
public class boj_S1_11047_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] change = new int[N];
		int amount = 0;
		for(int i=0; i<N; i++) {
			change[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(change[i] <= K) {
				amount += K/change[i];
				K %= change[i];
			}
		}
		System.out.println(amount);
	}
}
