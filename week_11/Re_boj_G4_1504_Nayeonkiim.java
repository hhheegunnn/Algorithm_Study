package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

//1 -> M1 최단거리, M1 -> M2 최단거리, M2 -> N의 최단거리
//1 -> M2 최단거리, M2 -> M1 최단거리, M1 -> N의 최단거리
//둘 중 최소값이 답이 된다.
public class Re_boj_G4_1504_Nayeonkiim {
    public static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N,E;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] check;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 weight (가중치)
            a.get(start).add(new Node(end, weight));

            // end에서 start로 가는 weight (가중치)
            a.get(end).add(new Node(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1,v1);
        res1 += dijkstra(v1,v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}