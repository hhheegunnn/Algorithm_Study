package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_S1_2583_Nayeonkiim {
	
	public static int[] nx = { 1, 0, -1, 0 };
	public static int[] ny = { 0, 1, 0, -1 };
	public static int count = 0;
	public static void main(String[] args) throws Exception, IOException {
		//m은 가로, n은 세로
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i < K; i++) {
			String[] str = bf.readLine().split(" ");
			for(int h=Integer.parseInt(str[0]); h < Integer.parseInt(str[2]); h++) {
				for(int g=Integer.parseInt(str[1]); g<Integer.parseInt(str[3]); g++) {
					arr[h][g] = 1;
				}
			}
		}
		
		int ans = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(arr[i][j] == 0) {
					count = 1;
					arr[i][j] = 1;
					
					dfs(arr, i, j);
					list.add(count);
					ans += 1;
				}
			}
		}
		
		System.out.println(ans);
		Collections.sort(list);
		for(int a : list) {
			System.out.print(a + " ");
		}
	}
	
	private static void dfs(int[][] arr, int y, int x) {
		for(int i=0; i < 4; i++) {
			int nextY = y+ny[i];
			int nextX = x+nx[i];
			
			if(nextX >= 0 && nextY >= 0 && nextY < arr.length && nextX < arr[0].length && 
					arr[nextY][nextX] == 0) {
				
				arr[nextY][nextX] = 1;
				dfs(arr, nextY, nextX);
				count++;
			}
		}
	}

}
