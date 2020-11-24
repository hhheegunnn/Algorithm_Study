package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//dfs가 아닌 bfs 활용 이유 : 목적지에 도착했을 당시 최소 이동 횟수를 구해야 하기 때문
public class boj_S2_7562_Nayeonkiim {
	public static class Point{
		int x;
		int y;
		int count;
		Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	public static int[] nx = { -2,-2,-1,1,2,2,1,-1 };
	public static int[] ny = { -1,1,2,2,1,-1,-2,-2 };
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i < N; i++) {
			int l = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			Point cur = new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]),0);
			String[] st = br.readLine().split(" ");
			Point fin = new Point(Integer.parseInt(st[0]),Integer.parseInt(st[1]),0);
			
			Queue<Point> que = new LinkedList<Point>();
			que.add(cur);
			boolean[][] visited = new boolean[l][l];
			visited[cur.x][cur.y] = true;
			
			while(!que.isEmpty()) {
				Point p = que.poll();
				if(p.x == fin.x && p.y == fin.y) {
					System.out.println(p.count);
					break;
				}
				
				for(int j=0; j < 8; j++) {
					int xp = p.x + nx[j];
					int yp = p.y + ny[j];
					
					if(xp >= 0 && xp < l && yp >= 0 && yp < l && !visited[xp][yp]) {
						visited[xp][yp] = true;
						que.add(new Point(xp,yp,p.count+1));
					}
				}
			}
		}
		
	}

}
