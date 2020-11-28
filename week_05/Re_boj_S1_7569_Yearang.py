import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class boj_S1_7569_Yearang {
    static int m, n, h, a, b, c;
    static int[][][] box;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        h = s.nextInt();
        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = s.nextInt();
                    if (box[i][j][k] == 1) {
                        xq.add(j);
                        yq.add(k);
                        hq.add(i);
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if (answer - 1 == -1) {
            System.out.println(0);
            return;
        }
        System.out.println(answer-1);


    }

    static boolean[][][] visited;
    static Queue<Integer> xq = new LinkedBlockingDeque<Integer>();
    static Queue<Integer> yq = new LinkedBlockingDeque<Integer>();
    static Queue<Integer> hq = new LinkedBlockingDeque<Integer>();
    static int[] xx = {1, 0, 0, -1, 0, 0};
    static int[] yy = {0, 1, 0, 0, -1, 0};
    static int[] hh = {0, 0, 1, 0, 0, -1};

    static int aa, bb, cc, answer;

    public static void bfs() {
//        a = xq.poll();
//        b = yq.poll();
//        h = hq.poll();
//        visited[h][b][a] = true;

        while (!xq.isEmpty() && !yq.isEmpty() && !hq.isEmpty()) {
            a = xq.poll();
            b = yq.poll();
            c = hq.poll();
            for (int i = 0; i < 6; i++) {
                aa = a + xx[i];
                bb = b + yy[i];
                cc = c + hh[i];

                if (aa < n && bb < m && cc < h && aa >= 0 && bb >= 0 && cc >= 0) {
                    if (box[cc][aa][bb] == 0) {
                        box[cc][aa][bb] = box[c][a][b] + 1;
                        xq.add(aa);
                        yq.add(bb);
                        hq.add(cc);
                        answer = box[cc][aa][bb];
                    }
                }


            }
        }


    }
}
