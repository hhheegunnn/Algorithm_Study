package boj구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Re_S1_boj_11286_Nayeonkiim {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				}else if(Math.abs(o1) > Math.abs(o2)) {
					return 1;
				}else {
					if(o1 < o2) {
						return -1;
					}else if(o1 > o2){
						return 1;
					}else
						return 0;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < N; i++) {
			int ans = Integer.parseInt(bf.readLine());
			if(ans != 0) {
				pq.add(ans);
			}else {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}
		}
	}
}
