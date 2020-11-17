package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_S3_2606_Nayeonkiim {
	static int count = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());  //컴퓨터의 수
		int sang = Integer.parseInt(br.readLine());  //쌍의 수
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i <= com; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i < sang; i++) {
			String[] str = br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		//com+1 주의
		boolean[] visited = new boolean[com+1];
		//1번 컴퓨터와 연결된 것만 count 하면 되니깐
		dfs(1,list,visited);
		System.out.println(count-1);
		
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
		//이미 방문한 경우 return
		if(visited[i])
			return;
		
		visited[i] = true;
		//방문한 컴퓨터수 + 1
		count+=1;
		
		for(int k : list.get(i)) {
			//연결되어 있는 컴푸터 하나씩 
			dfs(k, list, visited);
		}
	}
}
