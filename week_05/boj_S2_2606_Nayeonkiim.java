package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_S2_2606_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int gan = Integer.parseInt(br.readLine());
		
		Queue<Integer> st = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i <= com; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < gan; i++) {
			String[] str = br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		int ans = 0;
		boolean[] visited = new boolean[com+1];
		st.add(1);
		while(!st.isEmpty()) {
			int p = st.poll();
			
			if(!visited[p]) {
				ans++;
				visited[p] = true;
				for(int k : list.get(p)) {
					st.add(k);
				}
			}
		}
		System.out.println(ans-1);
	}
}
