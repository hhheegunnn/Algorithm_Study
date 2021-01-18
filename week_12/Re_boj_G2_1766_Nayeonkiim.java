package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1번이 가장 쉬운 문제, N번 문제가 가장 어려운 문제
//N개 문제 모두 풀어야 해
//먼저 푸는 것이 좋은 문제가 있으면 반드시 먼저풀기
//가능하면 쉬운 문제부터 풀기
public class Re_boj_G2_1766_Nayeonkiim {
    public static int[] indegree;
    public static int N,M;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> result = new ArrayList<>();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //문제의 수
        M = Integer.parseInt(st.nextToken()); //정보의 개수

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            indegree[B]+=1;
        }

        topologySort();

        for(int i=0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

    private static void topologySort() {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=1; i <= N; i++){
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int p = q.poll();
            result.add(p);

            for(int i=0; i < graph.get(p).size(); i++){
                indegree[graph.get(p).get(i)]--;
                if(indegree[graph.get(p).get(i)] == 0){
                    q.offer(graph.get(p).get(i));
                }
            }
        }

    }
}
