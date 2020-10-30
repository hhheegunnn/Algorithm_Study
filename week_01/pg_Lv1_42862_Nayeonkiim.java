package week_01;

public class pg_Lv1_42862_Nayeonkiim {
	
	 public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        
	        int[] arr = new int[n+1];
	        for(int i = 0; i < reserve.length; i++){
	            arr[reserve[i]] = 2;
	        }
	        
	        
	        for(int j = 0; j < lost.length; j++){
	            if(arr[lost[j]] != 2)
	                arr[lost[j]] = -1;
	            else
	                arr[lost[j]] = 0;
	        }
	        
	        for(int i = 1; i <= n; i++){
	            if(arr[i] >= 0){
	                answer += 1;
	                arr[i]--;
	            }else if(arr[i] == -1){
	                if(i != 1 && arr[i-1] == 1){
	                    answer+=1;
	                    arr[i-1]--;
	                }else if(i != n && arr[i+1] == 2){
	                    answer+=1;
	                    arr[i+1]--;
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
