package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//RERE
public class Re_S2_2644_Nayeonkiim {
	static int[][] map;
	static int[] visited;
	static int N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		int r = -1;
		r = dfs(P1,P2,0);  //p1=7, p2=3
		
		System.out.println(r);
	}
	
	private static int dfs(int src, int dst, int nChon) {
		if(src == dst)
			return nChon;
		
		visited[src] = 1;
		
		int r= -1;
		for(int i=1; i <=N; ++i) {
			if((map[src][i] == 1) && (visited[i] == 0)) {
				int subR = dfs(i,dst,nChon+1);
				if(subR != -1)
					r = subR;
			}
		}
		return r;
	}
}
