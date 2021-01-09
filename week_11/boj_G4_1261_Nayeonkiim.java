package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//상하좌우로 인접한 빈방 이동가능 (x+1, y), (x, y+1), (x-1, y), (x, y-1)
public class boj_G4_1261_Nayeonkiim {
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count < o.count)
                return -1;
            return 1;
        }
    }
    public static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int M;
    public static int N;
    public static int[][] miro;
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());  //가로
        N = Integer.parseInt(st.nextToken());  //세로

        miro = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for(int i=1; i <= N; i++){
            String[] str = br.readLine().split("");
            for(int j=1; j <= M; j++){
                miro[i][j] = Integer.parseInt(str[j-1]);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,1,0));
        visited[1][1] = true;

loop:   while(!pq.isEmpty()) {
            Node p = pq.poll();

            int x = p.x;
            int y = p.y;

            if(y == N && x == M) {
                ans = p.count;
                break loop;
            }

            for(int i=0; i < 4; i++) {
                int nextY = y+move[i][0];
                int nextX = x+move[i][1];

                if(nextY > 0 && nextY <= N && nextX > 0 && nextX <= M && !visited[nextY][nextX]){
                    if(miro[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        pq.add(new Node(nextX, nextY, p.count+1));
                    }else{
                        visited[nextY][nextX] = true;
                        pq.add(new Node(nextX, nextY, p.count));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
