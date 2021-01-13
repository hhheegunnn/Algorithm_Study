package week12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//가장먼노드
public class pg_Lv3_49189_Nayeonkiim {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] visited;
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        visited = new int[n+1];
        for(int i=0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i < edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);

        }

        quest(1);

        for(int i=1; i <= n; i++){
            if(answer < visited[i]){
                answer = visited[i];
            }
        }
        int ans = 0;
        for(int i=1; i <= n; i++){
            if(answer == visited[i]){
                ans += 1;
            }
        }

        return ans;
    }

    private static void quest(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = 1;

        while(!que.isEmpty()) {
            int p = que.poll();

            for (int i = 0; i < graph.get(p).size(); i++) {
                int nextIdx = graph.get(p).get(i);
                if (visited[nextIdx] == 0) {
                    visited[nextIdx] = visited[p] + 1;
                    que.add(nextIdx);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n,edge));
    }
}
