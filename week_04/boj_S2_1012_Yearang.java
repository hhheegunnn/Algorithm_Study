import java.util.*;

public class boj_S2_1012_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            answer = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            ad = new int[m][n];
            visit = new boolean[m][n];
            List<int[]> test = new ArrayList<>();
            for(int j = 0; j < k; j++) {
                int t1 = sc.nextInt();
                int t2 = sc.nextInt();
                ad[t1][t2] = 1;
                test.add(new int[]{t1, t2});
            }

            for(int[] tt : test) {
                if(visit[tt[0]][tt[1]]) {
                    continue;
                }
                bfs(tt[0], tt[1]);
                answer++;
            }
            System.out.println(answer);
        }

    }

    static boolean[][] visit;
    static int m, n, answer;
    static int [][] ad;
    static int [] xd = {1, 0, -1, 0};
    static int [] yd = {0, 1, 0, -1};

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int[] tmp = {i,j};
        q.offer(tmp);


        while(!q.isEmpty()){
            int[] temp = q.poll();
            visit[temp[0]][temp[1]] = true;
            int x, y;
            for(int k = 0; k < 4; k++) {
                x = temp[0] + xd[k];
                y = temp[1] + yd[k];
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    if(visit[x][y] == false && ad[x][y] == 1) {
                        visit[x][y] = true;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
