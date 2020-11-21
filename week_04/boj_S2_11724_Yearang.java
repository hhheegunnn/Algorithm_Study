import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_S2_11724_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[n+1];
        ad = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            ad.add(new ArrayList<>());
        }
        for(int i  = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            ad.get(u).add(v);
            ad.get(v).add(u);
        }

        int answer = 0;
        for(int i = 1; i < n+1; i++) {
            if(visit[i]) {
                continue;
            }
            dfs(i);
            answer++;
        }

        System.out.println(answer);
    }

    static List<List<Integer>> ad;
    static boolean [] visit;
    static int n;

    public static void dfs(int i) {
        visit[i] = true;

        for(int j : ad.get(i)) {
            if(!visit[j]) {
                dfs(j);
            }
        }

    }
}
