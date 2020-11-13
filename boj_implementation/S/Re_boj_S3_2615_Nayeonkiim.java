package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_2615_Nayeonkiim {
	//오목 가능 경우의 수 : 4가지(가로,세로,대각선 두개)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] way = { {0,1}, {1,1}, {1,0}, {1,-1} };
		int[][] omok = new int[20][20];
		
		for(int i=0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < 19; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int win = 0;
		boolean[][][] visited = new boolean[4][20][20];
OUTER:		for(int i=0; i < 19; i++) {
			for(int j=0; j < 19; j++) {
				if(omok[i][j] == 0)
					continue;
				else {
					for(int w=0; w < 4; w++) {
						int x = i + way[w][0];
						int y = j + way[w][1];
						int count = 1;
						visited[w][i][j]=true;
						
						while(x>=0 && y>=0 && x < 19 && y < 19 &&
								omok[i][j] == omok[x][y] && !visited[w][x][y]) {
							visited[w][x][y] = true;	
							count++;
							x += way[w][0];
							y += way[w][1];
						}
						
						if(count == 5) {
							win++;
							System.out.println(omok[i][j]);
							if(w != 3) {
								System.out.println((i+1)+" "+(j+1));
							}else {
								System.out.println((i+5)+" "+(j-3));
							}
							break OUTER;
						}
					}
				}
			}
		}
		if(win == 0) {
			System.out.println(0);
		}
	}
}
