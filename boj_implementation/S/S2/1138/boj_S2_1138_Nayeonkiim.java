package boj구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_S2_1138_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		String[] str = br.readLine().split(" ");
		int[] order = new int[N];
		for(int i=0; i < N; i++) {
			order[i] = Integer.parseInt(str[i]);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=N-1; i >= 0; i--) {
			list.add(order[i], i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < N; i++) {
			sb.append(list.get(i)+" ");
		}
		System.out.println(sb);
	}
}
