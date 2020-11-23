package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_S2_1012_Nayeonkiim {
	public static int[] nx = {-1,0,1,0};
	public static int[] ny = {0,1,0,-1};
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //가로길이
			int N = Integer.parseInt(st.nextToken()); //세로길이
			int K = Integer.parseInt(st.nextToken()); //위치의 개수
			int[][] bat = new int[N][M];
			
			for(int j=0; j < K; j++) {
				StringTokenizer pos = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(pos.nextToken());  //가로
				int Y = Integer.parseInt(pos.nextToken());  //세로
				
				bat[Y][X] = 1;
			}
			
			int ans = 0;
			for(int j=0; j < N; j++) {  //세로
				for(int k=0; k < M; k++) { //가로
					if(bat[j][k] == 1) {
						dfs(bat,j,k,N,M);
						ans += 1;
					}
				}
			}
			System.out.println(ans);
		}
	}
	private static void dfs(int[][] bat, int j, int k, int N, int M) {
		//j 세로, k 가로, N 세로, M 가로
		if(bat[j][k] != 1)
			return;
		
		bat[j][k] = 0;
		for(int i=0; i < 4; i++) {
			int yy = j+ny[i];
			int xx = k+nx[i];
			if( xx >= 0 && xx < M && yy >= 0 && yy < N && bat[yy][xx] == 1)
				dfs(bat, yy, xx, N, M);
		}
	}

}
