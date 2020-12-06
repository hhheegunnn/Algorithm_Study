import java.util.*;

public class boj_S3_2606_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int n = sc.nextInt();

        al = new ArrayList<>();
        visit = new boolean[e+1];
        for(int i = 0; i <= e; i++) {
            al.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            al.get(a).add(b);
            al.get(b).add(a);
        }
        visit[1] = true;
        bfs(1);
        System.out.println(answer);




    }

    static List<List<Integer>> al;
    static boolean[] visit;
    static int answer = 0;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int alTmp : al.get(tmp)) {
                if(visit[alTmp] == false) {
                    visit[alTmp] = true;
                    answer++;
                    q.add(alTmp);
                }
            }
        }

    }

}
