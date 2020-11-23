package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_S2_11724_Nayeonkiim {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < M; i++) {
			String[] st = br.readLine().split(" ");
			list.get(Integer.parseInt(st[0])).add(Integer.parseInt(st[1]));
			list.get(Integer.parseInt(st[1])).add(Integer.parseInt(st[0]));
		}
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		
		int ans = 0;
		for(int i=1; i < list.size(); i++) {
			if(!visited[i]) {
				que.add(i);
				ans++;
				while(!que.isEmpty()) {
					int q = que.poll();
					
					if(!visited[q]) {
						visited[q] = true;
						for(int k : list.get(q)) {
							que.add(k);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
