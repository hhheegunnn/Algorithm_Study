import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_S2_2644_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p1 = sc.nextInt();
        p2 = sc.nextInt();
        int m = sc.nextInt();
        ad = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            ad.add(new ArrayList<>());
        }
        visit = new int[n+1];
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ad.get(x).add(y);
            ad.get(y).add(x);
        }

        dfs(p1,-1);
        System.out.println(answer == 0 ? -1 : answer);

    }

    public static List<List<Integer>> ad;
    public static int[] visit;
    public static int answer, p2, before;

    public static void dfs(int i, int before) {
        visit[i] = before + 1;
        if(i == p2) {
            answer = visit[i];
            return;
        }
        for(int j : ad.get(i)) {
            if(visit[j] == 0) {
                dfs(j, visit[i]);
            }
        }

    }
}
