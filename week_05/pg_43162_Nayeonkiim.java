package week5;

import java.util.ArrayList;

public class pg_43162_Nayeonkiim {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i < computers.length; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i < computers.length; i++) {
        	for(int j=0; j < computers[i].length; j++) {
        		if(computers[i][j] == 1) {
        			list.get(i).add(j);
        			list.get(j).add(i);
        		}
        	}
        }
        
        boolean[] visited = new boolean[n];
        for(int i=0; i < computers.length; i++) {
        	if(!visited[i]) {
        		dfs(list,i,visited);
        		answer++;
        	}
        }
        
        return answer;
    }
	
	private void dfs(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited) {
		if(visited[i])
			return;
		
		visited[i] = true;
		
		for(int k : list.get(i)) {
			dfs(list,k,visited);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		pg_43162_Nayeonkiim net = new pg_43162_Nayeonkiim();
		System.out.println(net.solution(n, computers));
	}

}
