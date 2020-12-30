package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Re_boj_S1_13335_Nayeonkiim {
	
	static int N, maxWeight, Length, T = 0;
	static int[] truck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Length = Integer.parseInt(st.nextToken());
		maxWeight = Integer.parseInt(st.nextToken());

		truck = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(Length,maxWeight,truck));

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, i = 0, total = 0;
        int ch = 0, idx = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int j=0;j<bridge_length;j++) {
        	que.add(0);
        }
       
        while(i < truck_weights.length) {
        	if(que.size() == bridge_length) {
        		//poll한 만큼을 측정
        		idx = que.poll();
        		total-= idx;
        	}
        	if(total+truck_weights[i] <= weight) {
        		que.add(truck_weights[i]);
        	
        		total += truck_weights[i];
        		i++;
        		time+=1;
        	}else {
        		que.add(0);
        		time++;
        	}
        }
       
        time+=bridge_length;
        return time;
	}
}
