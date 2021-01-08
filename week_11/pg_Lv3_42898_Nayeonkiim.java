package week11;


public class pg_Lv3_42898_Nayeonkiim {
	//오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
       
        int[][] d = new int[m+1][n+1];
        for(int i=0; i < puddles.length; i++) {
        	d[puddles[i][0]][puddles[i][1]] = -1;
        }
       
        
        d[1][1] = 1;
        for(int i=1; i <= m; i++) {
        	for(int j=1; j <= n; j++) {
        		if(d[i][j] == -1)
        			continue;
        		if(i==1 && j==1)
        			continue;
        		
        		if(d[i-1][j] != -1 && d[i][j-1] != -1) {
        			d[i][j] = d[i-1][j]+d[i][j-1];

        		}else if(d[i-1][j] == -1) {
        			d[i][j] = d[i][j-1];
        		}else if(d[i][j-1] == -1) {
        			d[i][j] = d[i-1][j];
        		}
        		d[i][j] %=1000000007;
        	}
        }
        
        return d[m][n];
    }
	
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		System.out.println(solution(m, n, puddles));
	}

}
