import java.util.ArrayList;
import java.util.List;

public class pg_Lv3_43162_Yearang {
    public static void main(String[] args) {
        int[][] t = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int [][] t2 =  {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(3, t);
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visit[i] == false) {
                dfs(i, n, computers);
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
    static List<List<Integer>> al = new ArrayList<>();
    static boolean visit[];
    public static void dfs(int e, int n, int[][] computers) {
        visit[e] = true;

        for(int i = 0; i < n; i++) {
            if(!visit[i] && i != e && computers[i][e] == 1) {
                dfs(i, n, computers);
            }
        }
    }
}
