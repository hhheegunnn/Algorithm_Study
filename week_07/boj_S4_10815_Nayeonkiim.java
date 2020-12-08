package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//상근이가 가지고 있는지 아닌지를 구하는 프로그램 -> 이분탐색
public class boj_S4_10815_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//1 <= N <= 500000
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		String[] str = bf.readLine().split(" ");
		for(int i=0; i < N; i++) {
			//-10000000 < arr[i] < 10000000
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());
		
		int[] com = new int[M];
		String[] str2 = bf.readLine().split(" ");
		for(int i=0; i < M; i++) {
			com[i] = Integer.parseInt(str2[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < M; i++) {
			int start = 0, end = arr.length-1, con = 0;
			while(start <= end) {
				int mid = (start+end)/2;
				int count = arr[mid];
				if(count < com[i]) {
					start = mid+1;
				}else{
					if(count == com[i]) {
						sb.append(1 + " ");
						con = 1;
					}
					end = mid-1;
				}
			}
			if(con == 0) {
				sb.append(0 + " ");
			}
			con = 0;
		}
		
		System.out.println(sb.toString());
	}

}
