import java.util.*;

public class boj_S2_4963_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) {
                break;
            }
            square = new int[w][h];
            ArrayList<int[]> al = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    square[j][i] = sc.nextInt();
                    if(square[j][i] == 1) {
                        int[] tmp = {j,i};
                        al.add(tmp);
                    }
                }
            }
            // data input end
            visit = new boolean[w][h];
            int answer= 0;
            for(int[] t : al) {
                if(!visit[t[0]][t[1]]) {
                    bfs(t[0],t[1]);
                    answer++;
                }
            }
            System.out.println(answer);


        }

    }

    static boolean[][] visit;
    static int[] xx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] yy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int w, h;
    static int[][] square;

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int[] tmp = {i, j};
        q.offer(tmp);

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int n = 0; n < 8; n++) {
                if (x + xx[n] >= 0 && x + xx[n] < w && y + yy[n] >= 0 && y + yy[n] < h) {
                    if (square[x+xx[n]][y+yy[n]] == 1 && visit[x + xx[n]][y + yy[n]] == false) {
                        int[] temp = {x+xx[n], y+yy[n]};
                        visit[x+xx[n]][y+yy[n]] = true;
                        q.offer(temp);
                    }
                }

            }
        }
    }
}
