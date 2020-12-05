package boj구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj_S1_5567_Nayeonkiim {
	public static int ans = 0;
	public static class Point{
		int rel;
		int num;
		Point(int rel, int num){
			this.rel = rel;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //동기수
		int m = Integer.parseInt(br.readLine()); //친구관계 갯수
		
		List<List<Integer>> list = new ArrayList<>();
		int[] visited = new int[n+1];
		for(int i=0; i < n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		int rel = 0;
		Queue<Point> que = new LinkedList<>();
		
		que.add(new Point(rel,1));
		visited[1] = 1;
				
		while(!que.isEmpty()) {
			Point p = que.poll();
					
			for(int j : list.get(p.num)) {
				if(visited[j] == 0 && p.rel < 2) {
					visited[j] = 1;
					ans+=1;
					que.add(new Point(p.rel+1,j));
				}
			}
		}
		
		System.out.println(ans);
	}
}
