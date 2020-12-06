import java.util.*;

public class boj_S1_7576_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];
        List<int[]> one = new ArrayList<>();
        count = 0;
        int minus = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1) {
                    count++;
                    int[] t = {i,j};
                    one.add(t);
                    q.add(t);
                } else if(box[i][j] == -1) {
                    minus++;
                }
            }
        }

        if(count == m*n || m*n - minus == count) {
            System.out.println(0);
            return;
        }

//        for(int[] t : one) {
            bfs();
//        }

        for(int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);;
                    return;
                }
                if(box[i][j] > max) {
                    max = box[i][j];
                }
            }
        }

        if(count == m*n || m*n - minus == count) {
            System.out.println(max -1);
        } else {
            System.out.println(-1);
        }
    }

    static int[][] box;
    static int [] xx = {1,-1,0,0};
    static int [] yy = {0,0,1,-1};
    static int n, m, count, max;
    static Queue<int[]> q = new LinkedList<>();
    static void bfs() {
//        Queue<int[]> q = new LinkedList<>();
//        q.add(start);

        while(!q.isEmpty()) {
            int[] tmp  = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i = 0; i < 4; i++) {
                if(x + xx[i] >= 0 && x + xx[i] < n && y + yy[i] >= 0 && y + yy[i] < m) {
                   if(box[x+xx[i]][y+yy[i]] != -1 && box[x+xx[i]][y+yy[i]] != 1 && (box[x+xx[i]][y+yy[i]] >  box[x][y] + 1 || box[x+xx[i]][y+yy[i]]==0)) {
                       int[] tmpAdd = {x+xx[i], y+yy[i]};
                       q.add(tmpAdd);
                       if(box[x+xx[i]][y+yy[i]] == 0) {
                           count++;
                       }
                       box[x+xx[i]][y+yy[i]] = box[x][y]+1;
                   }
                }
            }
        }
    }
}
