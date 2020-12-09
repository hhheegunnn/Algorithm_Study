package week7;

import java.util.Arrays;

public class pg_lv2_42747_Nayeonkiim {
	//이분탐색 + 정렬
	public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int left = 1;
        int right = citations[citations.length-1];
        
        while(left <= right) {
        	int mid = (left+right)/2;
        	int count = calc(mid,citations);
        	if(count < mid) {
        		right = mid - 1;
        	}else {
        		answer = mid;
        		left = mid+1;
        	}
        }
        
        return answer;
    }
	
	private int calc(int mid, int[] citations) {
		int count = 0;
		for(int i=0; i < citations.length; i++) {
			if(citations[i] >= mid) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,3};
		pg_lv2_42747_Nayeonkiim h = new pg_lv2_42747_Nayeonkiim();
		System.out.println(h.solution(citations));
	}

}
