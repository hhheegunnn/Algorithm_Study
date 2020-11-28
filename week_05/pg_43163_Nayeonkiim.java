package week5;

import java.util.LinkedList;
import java.util.Queue;

public class pg_43163_Nayeonkiim {
	
	public static class Point{
		int round;
		char[] poll;
		Point(int round, char[] poll){
			this.round = round;
			this.poll = poll;
		}
	}
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        char[] beginCh = begin.toCharArray();
        char[] targetCh = target.toCharArray();
        int len = begin.length();
        
        Queue<Point> que = new LinkedList<Point>();
        que.add(new Point(0,beginCh));
        boolean[] visited = new boolean[words.length];
        //begin이랑 한글자만 다른 경우 que에 넣어
        
        while(!que.isEmpty()) {
        	Point beginPoll = que.poll();
        	String tar = new String(beginPoll.poll);
        	if(tar.equals(target)){
        		answer = beginPoll.round;
        		break;
        	}
        	
	        for(int i=0; i < words.length; i++) {
	        	char[] wordCh = words[i].toCharArray();
	        	
	        	int count = 0;
	        	for(int j=0; j < len; j++) {
	        		if(wordCh[j] == beginPoll.poll[j]) {
	        			count++;
	        		}
	        	}
	        	if(count== len-1 && !visited[i]) {
	        		visited[i] = true;
	        		que.add(new Point(beginPoll.round+1,wordCh));
	        	}
	        }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		pg_43163_Nayeonkiim dan = new pg_43163_Nayeonkiim();
		System.out.println(dan.solution(begin, target, words));
	}
}
