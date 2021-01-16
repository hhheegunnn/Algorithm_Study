package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_G2_2252_Nayeonkiim {
    //두 학생의 키를 비교하는 방법 이용
    public static List<List<Integer>> graph = new ArrayList<>();
    public static StringBuffer sb;
    public static int N, M;
    public static int[] into;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        sb = new StringBuffer();
        into = new int[N+1];
        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            into[B]++;
        }

        calc();
        System.out.println(sb.toString());
    }

    private static void calc() {
        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i <= N; i++){
            if(into[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int q = que.poll();
            sb.append(q + " ");

            for(int i=0; i < graph.get(q).size(); i++){
                into[graph.get(q).get(i)]--;
                if(into[graph.get(q).get(i)] == 0){
                    que.add(graph.get(q).get(i));
                }
            }

        }
    }
}
