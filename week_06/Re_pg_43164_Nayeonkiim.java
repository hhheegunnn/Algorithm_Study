package week5;

import java.util.ArrayList;
import java.util.Collections;

public class Re_pg_43164_Nayeonkiim {
	boolean[] visited;
	ArrayList<String> answers;
	
	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		answers = new ArrayList<String>();
		int count = 0;
		dfs(count, "ICN", "ICN", tickets);
		Collections.sort(answers);
		String[] answer = answers.get(0).split(" ");
		return answer;
		
	}
	
	private void dfs(int count, String present, String answer, String[][] tickets) {
		if(count == tickets.length) {
			answers.add(answer);
			return;
		}
		for(int i=0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(present)) {
				visited[i] = true;
				dfs(count+1, tickets[i][1], answer+" "+tickets[i][1], tickets);
				visited[i] = false;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		//String[][] tickets = {{"ICN","A"},{"ICN","B"},{"B","ICN"}};
		//String[][] tickets = {{"ICN","A"},{"ICN","A"},{"A","ICN"}};
		Re_pg_43164_Nayeonkiim go = new Re_pg_43164_Nayeonkiim();
		for(int i=0; i < go.solution(tickets).length; i++)
			System.out.print(go.solution(tickets)[i] +" ");
	}
}
