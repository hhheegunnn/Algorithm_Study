import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj_S2_7562_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            l = sc.nextInt();
            int[] current = {sc.nextInt(), sc.nextInt()};
            goal = new int[]{sc.nextInt(), sc.nextInt()};
            visit = new boolean[l][l];
            bfs(current[0], current[1]);


        }


    }
    static boolean[][] visit;
    static int[] xx = {1,1,-1,-1,2,2,-2,-2};
    static int[] yy = {2,-2,2,-2,1,-1,1,-1};
    static int l;
    static int [] goal;

    static void bfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();

        int[] start = {i, j, 0};
        queue.add(start);

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if(x == goal[0] && y==goal[1]) {
                System.out.println(poll[2]);
                return;
            }
            for(int k = 0; k < 8; k++) {
                if(x + xx[k] >= 0 && x + xx[k] < l && y+yy[k] >=0 && y+yy[k] < l) {
                    if(visit[x+xx[k]][y+yy[k]] == false) {
                        visit[x+xx[k]][y+yy[k]] = true;
                        int[] tmp = {x+xx[k],y+yy[k], poll[2] + 1};
                        queue.add(tmp);
                    }
                }
            }
        }
    }
}
