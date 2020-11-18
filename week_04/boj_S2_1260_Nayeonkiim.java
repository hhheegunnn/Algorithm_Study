package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj_S2_1260_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int start = Integer.parseInt(str[2]);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			String[] st = bf.readLine().split(" ");
			list.get(Integer.parseInt(st[0])).add(Integer.parseInt(st[1]));
			list.get(Integer.parseInt(st[1])).add(Integer.parseInt(st[0]));
		}
		//System.out.print(list.toString());
		
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> dlist = new ArrayList<>();
		
		//start와 연결된 것만 탐색하면 됨
		dfs(start,list,visited,dlist);
		
		for(int i=0; i < dlist.size(); i++) {
			System.out.print(dlist.get(i) + " ");
		}
		System.out.println();
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> blist = new ArrayList<>();
		boolean[] bvisited = new boolean[N+1];
		q.add(start);
		blist.add(start);
		bvisited[start] = true;
		
		while(!q.isEmpty()) {
			int qremove = q.remove();
			for(int k : list.get(qremove)) {
				if(!bvisited[k]) {
					bvisited[k] = true;
					blist.add(k);
					q.add(k);
				}
			}
		}
		for(int i=0; i < blist.size(); i++) {
			System.out.print(blist.get(i) + " ");
		}
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited, ArrayList<Integer> dlist) {
		if(visited[i]) { 
			return;
		}
		
		visited[i] = true;
		dlist.add(i);
		Collections.sort(list.get(i));
		
		for(int k : list.get(i))
			dfs(k,list,visited,dlist);
	}

}

//반례
//1000 10 4
//4 1000
//1000 1
//1000 2
//1000 3
//1000 4
//4 500
//4 600
//2 5
//5 9
//1 24
