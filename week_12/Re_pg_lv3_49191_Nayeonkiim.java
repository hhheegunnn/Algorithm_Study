package week12;

import java.util.*;

public class Re_pg_lv3_49191_Nayeonkiim {
    static int INF = 987654321;
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] scores = new int[n+1][n+1];
        int win, lose;

        for(int[] score : scores){
            Arrays.fill(score, INF);
        }

        for(int i=0; i < scores.length; i++) {
            for(int j=0; j < scores.length; j++){
                if(i==j) scores[i][j] = 0;
            }
        }

        for(int[] result:results) {
            win = result[0];
            lose = result[1];
            scores[win][lose] = 1;
        }

        for(int k=1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    if(scores[i][j] > scores[i][k] + scores[k][j]){
                        scores[i][j] = scores[i][k] + scores[k][j];
                    }
                }
            }
        }

        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=1; i <=n; i++){
            for(int j=1; j <= n; j++){
                if(i==j) continue;
                if(scores[i][j]==INF && scores[j][i] == INF){ //경로가 존재하지 않음
                    flag[i] = false;
                    break;
                }
            }
        }

        for(int i=1; i<flag.length; i++){
            if(flag[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] result = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        int n = 5;
        System.out.println(solution(n,result));
    }
}
