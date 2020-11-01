package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 걸리는 최소인 것부터 더해주기
public class boj_S3_11399_Nayeonkiim {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] num = br.readLine().split(" ");
		int[][]time = new int[N+1][2];
		
		//2차원 배열로 (i,걸리는 시간) 저장
		for(int i = 1; i <= N; i++) {
			time[i][0] = i;
			time[i][1] = Integer.parseInt(num[i-1]); 
		}
		
		//걸리는 시간 기준으로 오름차순 정렬
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(time[i][0] +" " + time[i][1]);
//		}
		
		//문제 조건에 맞게 더해주기
		int sum = 0, ans = 0;
		for(int i=1; i<=N; i++) {
			sum += time[i][1];
			ans += sum;
		}
		System.out.println(ans);
	}
}
