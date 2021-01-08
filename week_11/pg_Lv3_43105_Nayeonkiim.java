package week11;

public class pg_Lv3_43105_Nayeonkiim {
	public static int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] d = new int[len+1][len+1];
        
        d[1][1] = triangle[0][0];
        for(int i=2; i <= len; i++) {
        	for(int j=1; j <= i; j++) {
        		d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + triangle[i-1][j-1];
        	}
        }
        for(int i=1; i <= len; i++) {
        	if(answer < d[len][i])
        		answer = d[len][i];
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}
