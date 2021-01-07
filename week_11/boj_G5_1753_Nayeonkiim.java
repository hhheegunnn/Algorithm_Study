package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_G5_1753_Nayeonkiim {
	
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
	
	public static int[] d;
	public static List<List<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점의 갯수
		int E = Integer.parseInt(st.nextToken()); //간선의 갯수
		int K = Integer.parseInt(br.readLine()); //시작 정점의 번호
		
		d = new int[V+1];
		Arrays.fill(d, (int)1e9);
		
		for(int i=0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); //가중치
			
			graph.get(u).add(new Node(v,w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(K,0));
		d[K] = 0;
		
		while(!pq.isEmpty()) {
			Node no = pq.poll();
			
			for(int i=0; i < graph.get(no.idx).size(); i++) {
				int con = d[no.idx] + graph.get(no.idx).get(i).weight;
				if(d[graph.get(no.idx).get(i).idx] > con) {
					d[graph.get(no.idx).get(i).idx] = con;
					pq.add(new Node(graph.get(no.idx).get(i).idx, con));
				}
			}
		}
		
		for(int i=1; i < V+1; i++) {
			if(d[i] == 1e9) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	}

}
