package Greedy;

public class Re_pg_Lv2_42883_Nayeonkiim {
	
	public String solution(String number, int k) {
       StringBuilder sb = new StringBuilder();
       
       int left = 0;
       int right = k;
       int max = -1;
       int idx = 0;
       
       while(right != number.length()) {
    	   max = -1;
    	   for(int j = left; j <= right; ++j) {
    		   int num = number.charAt(j) - '0';
    		   if(num > max) {
    			   idx = j;
    			   max = num;
    		   }
    	   }
    	   sb.append(number.charAt(idx));
    	   left = idx + 1;
    	   right +=1;
       }
       return sb.toString();
	}
}
