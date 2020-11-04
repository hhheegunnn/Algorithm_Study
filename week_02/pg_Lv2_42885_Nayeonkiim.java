package pro;

import java.util.*;

class pg_Lv2_42885_Nayeonkiim {
    public int solution(int[] people, int limit) {
		int ans = 0, k = 0;
		
		Arrays.sort(people);
		
        int idx = 0;
		boolean[] use = new boolean[people.length];
        for(int i=people.length-1; i>=0; i--){
            //최소 몸무게가 40kg 이므로 limit-40보다 클 경우 비교 안하기 위해
            //sort 후 제일 처음 limit-40보다 큰 수 i를 idx에 저장
            if(people[i] > limit-40){
                idx =i;
                ans+=1;
            }else{
                break;
            }
        }
        //이미 더해준 세 준 경우 다시 체크 안하기 위해
        int start = idx;
		for(int i=0; i<idx-1; i++) {
			for(int j=start-1; j>i; j--) {
				if(people[i] + people[j] <= limit && use[j] == false) {
					//사용 후 true로 변경
                    use[j] = true;
					use[i] = true;
					ans+=1;
                    start-=1;
					break;
				}
			}
		}
		
        //사용하지 않은 것 count
		for(int i=0; i<idx; i++) {
			if(use[i] == false) {
				ans+=1;
			}
		}
       
		return ans;
	
    }
}