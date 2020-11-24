package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_S1_7569_Nayeonkiim {
	//위,아래,왼쪽,오른쪽,앞,뒤 -> bfs
	public static int[] nx = {0,0,-1,1,0,0};
	public static int[] ny = {1,-1,0,0,0,0};
	public static int[] nz = {0,0,0,0,-1,1};
	public static class Point{
		int x;
		int y;
		int z;
		int count;
		Point(int x, int y, int z, int count){
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int M = Integer.parseInt(str[0]);  //가로
		int N = Integer.parseInt(str[1]);  //세로
		int H = Integer.parseInt(str[2]);  //쌓아올려지는 상자 수
		int[][][] sam = new int[H][N][M];
		
		int k = 0;
		while(k < H) {
			for(int i=0; i < N; i++) {
				String[] st = br.readLine().split(" ");
				for(int j=0; j < M; j++) {
					sam[k][i][j] = Integer.parseInt(st[j]);
				}
			}
			k++;
		}
		
		boolean[][][] visited = new boolean[H][N][M];
		Queue<Point> que = new LinkedList<Point>();
		
		int count1 = 0, count2 = 0;
		for(int i=0; i < sam.length; i++) {
			for(int j=0; j < sam[i].length; j++) {
				for(int p=0; p < sam[i][j].length; p++) {
					if(sam[i][j][p] == 1) {
						count1++;
						que.add(new Point(p,j,i,0));
						visited[i][j][p] = true;
					}else if(sam[i][j][p] == -1) {
						count2++;
					}
				}
			}
		}
		
		if(count1 + count2 == N*M*H) {
			System.out.println("0");
			return;
		}
		
		int ans = 0;
		while(!que.isEmpty()) {
			Point q = que.poll();
			
			ans = q.count;
			for(int i=0; i < 6; i++) {
				int xx = q.x + nx[i];
				int yy = q.y + ny[i];
				int zz = q.z + nz[i];
				
				if(xx >= 0 && xx < M && yy >= 0 && yy < N && zz >= 0 && zz < H && sam[zz][yy][xx] == 0 && !visited[zz][yy][xx]) {
					sam[zz][yy][xx] = 1;
					visited[zz][yy][xx] = true;
					que.add(new Point(xx,yy,zz,q.count+1));
				}
			}
		}
		
		for(int i=0; i < sam.length; i++) {
			for(int j=0; j < sam[i].length; j++) {
				for(int p=0; p < sam[i][j].length; p++) {
					if(sam[i][j][p] == 0) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
