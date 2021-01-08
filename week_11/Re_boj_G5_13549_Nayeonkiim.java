package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Re_boj_G5_13549_Nayeonkiim {
	//1초 후에 X-1, X+1, 2*X -> 가장 빠른 시간이 몇 초 후인지 구하기
	public static class Node implements Comparable<Node>{
		int idx;
		int time;
		Node(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.time < o.time)
				return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		if(N >= K) {
			System.out.println(N-K);
			return;
		}

		
		boolean[] visited = new boolean[100001];
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(N,0));
		visited[N] = true;
		
		Node q = null;
		while(!que.isEmpty()) {
			q = que.poll();
			visited[q.idx] = true;
			
			if(q.idx == K) {
				break;
			}
			
			int min = q.idx - 1;
			int add = q.idx + 1;
			int mul = q.idx * 2;
			
			if(mul >= 0 && mul <= 100000 && !visited[mul]) {
				que.add(new Node(mul, q.time));
			}
			if(add >= 0 && add <= 100000 && !visited[add]) {
				que.add(new Node(add, q.time+1));
			}
			if(min >= 0 && min <= 100000 && !visited[min]) {
				que.add(new Node(min, q.time+1));
			}
		}
		System.out.println(q.time);
	}
}
