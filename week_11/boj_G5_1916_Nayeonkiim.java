package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_G5_1916_Nayeonkiim {
	public static class Node implements Comparable<Node>{
		int idx;
		int weight;
		Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.weight < o.weight) {
				return -1;
			}
			return 1;
		}
	}
	public static List<List<Node>> graph = new ArrayList<>();
	public static int[] d;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  //도시의 개수(정점)
		int M = Integer.parseInt(br.readLine());  //버스의 개수(간선)
		
		StringTokenizer st = null;
		for(int i=0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,c));
		}
		
		d = new int[100001];
		Arrays.fill(d, (int)1e9);
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node no = pq.poll();
			
			for(int i=0; i < graph.get(no.idx).size(); i++) {
				int con = d[no.idx] + graph.get(no.idx).get(i).weight;
				if(con < d[graph.get(no.idx).get(i).idx]) {
					d[graph.get(no.idx).get(i).idx] = con;
					pq.add(new Node(graph.get(no.idx).get(i).idx, con));
				}
			}
		}
		System.out.println(d[end]);
	}
}
