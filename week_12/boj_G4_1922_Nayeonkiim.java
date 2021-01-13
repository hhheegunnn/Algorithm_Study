package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//네트워크연결
//모든 컴퓨터가 연결, 최소로 하여 - 최소신장트리
public class boj_G4_1922_Nayeonkiim {
    static class Node implements Comparable<Node>{
        int a;
        int b;
        int distance;
        Node(int a, int b, int distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance < o.distance)
                return -1;
            return 1;
        }
    }
    public static ArrayList<Node> graph = new ArrayList<>();
    public static int[] parent = new int[1001];
    public static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a,b,c));
        }

        for(int i=1; i <= N; i++)
            parent[i]= i;

        Collections.sort(graph);

        for(int i=0; i < graph.size(); i++) {
            int a = graph.get(i).a;
            int b = graph.get(i).b;
            int distance = graph.get(i).distance;

            //root가 다른경우 union 연산
            if(findParent(a) != findParent(b)){
                union(a,b);
                ans += distance;
            }
        }
        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
}
