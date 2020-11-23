package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_S2_11725_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < N-1; i++) {
			String[] str = br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		boolean[] visited = new boolean[N+1];
		int[] parent = new int[N+1];
	
		dfs(1,list,visited,parent);
		
		for(int i=2; i < N+1; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] parent) {
		if(visited[i])
			return;
		
		visited[i] = true;
		for(int k : list.get(i)) {
			dfs(k,list,visited,parent);
			parent[k] = i;
		}
	}
}
