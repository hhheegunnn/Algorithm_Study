package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Re_pg_42861_Nayeonkiim {
	public int solution(int n, int[][] costs) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<costs.length; i++) {
        	if(map.get(costs[i][0]) == null) {
        		map.put(costs[i][0], new ArrayList<Integer>());
        	}
        	if(map.get(costs[i][1]) == null) {
        		map.put(costs[i][1], new ArrayList<Integer>());
        	}
        	List<Integer> list = map.get(costs[i][0]);
        	list.add(costs[i][1]);
        	
        	List<Integer> list2 = map.get(costs[i][1]);
        	list2.add(costs[i][0]);
        	
        	map.put(costs[i][0],list);
        	map.put(costs[i][1],list2);
        }
        
        for(int i=0; i < n; i++) {
        	boolean[] visited = new boolean[n];
        	int total = 0;
        	visited[i] = true;
        	go(total, visited, i, map, costs);
        }
        
        return answer;
    }
	
	private void go(int total, boolean[] visited, int i, Map<Integer,List<Integer>> map, int[][] costs) {
		
		for(int m : map.get(i)) {
        	if(!visited[m]) {
        		visited[m] = true;
        		for(int j=0; j < costs.length; j++) {
        			if(m == costs[j][0] && i == costs[j][1]) {
        				total += costs[j][2];
        				go(total,visited,m,map,costs);
        			}else if(i == costs[j][0] && m == costs[j][1]) {
        				total += costs[j][2];
        				go(total,visited,m,map,costs);
        			}
        		}
        			
        	}
    	}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		Re_pg_42861_Nayeonkiim p = new Re_pg_42861_Nayeonkiim();
		System.out.println(p.solution(n, costs));
	}

}
