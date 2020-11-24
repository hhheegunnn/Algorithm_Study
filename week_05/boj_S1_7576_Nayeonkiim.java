package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_S1_7576_Nayeonkiim {
	public static int[] nx = { 0,1,0,-1 };
	public static int[] ny = { 1,0,-1,0 };
	
	public static class Point{
		int x;
		int y;
		int count;
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count= count;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());  //가로
		int N = Integer.parseInt(st.nextToken());  //세로
		
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<Point> que = new LinkedList<Point>();
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					que.add(new Point(j,i,0));
					visited[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			ans = p.count;
			for(int i=0; i < 4; i++) {
				int xx = p.x + nx[i];
				int yy = p.y + ny[i];
				
				if(xx >= 0 && xx < M && yy >= 0 && yy < N && !visited[yy][xx] && arr[yy][xx] == 0) {
					arr[yy][xx] = 1;
					visited[yy][xx] = true;
					que.add(new Point(xx, yy, p.count+1));
				}
			}
		}
		for(int i=0; i < N; i++) {
			for(int j=0; j < M; j++) {
				if(arr[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(ans);
	}

}
