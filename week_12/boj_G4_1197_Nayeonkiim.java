package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//최소 스패닝 트리
//주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리 : 최소신장트리
public class boj_G4_1197_Nayeonkiim {
    static class Node implements Comparable<Node>{
        int a;
        int b;
        int weight;
        Node(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight < o.weight)
                return -1;
            return 1;
        }
    }
    static List<Node> graph = new ArrayList<>();
    static int[] parent = new int[10001];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         int V = Integer.parseInt(st.nextToken());
         int E = Integer.parseInt(st.nextToken());

         for(int i=0; i < E; i++) {
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken()); //a정점
             int b = Integer.parseInt(st.nextToken()); //b정점
             // C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
             int c = Integer.parseInt(st.nextToken()); //가중치

             graph.add(new Node(a,b,c));
         }

         Collections.sort(graph);

         for(int i=1; i <= V; i++){
             parent[i] = i;
         }

         for(int i=0; i < graph.size(); i++) {
             int a = graph.get(i).a;
             int b = graph.get(i).b;
             if(findParent(a) != findParent(b)){
                union(a,b);
                ans += graph.get(i).weight;
             }
         }
        System.out.println(ans);
     }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
}
