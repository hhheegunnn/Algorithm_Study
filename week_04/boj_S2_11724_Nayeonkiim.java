package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_S2_11724_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //정점 갯수
		int M = Integer.parseInt(st.nextToken());  //간선의 갯수
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		int ans = 0;
		boolean[] visited = new boolean[N+1];
		for(int i=1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i,list,visited);
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
		//이미 방문한 경우 return
		if(visited[i]) {
			return;
		}
		
		visited[i] = true;
		for(int k : list.get(i))
			dfs(k,list,visited);
	}
}
