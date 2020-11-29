import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj_S2_11725_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        al = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            al.add(new LinkedList<>());
        }


        for(int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            al.get(a).add(b);
            al.get(b).add(a);
        }
        answer = new int[n+1];
        visit = new boolean[n+1];
        dfs(1,0);
        for(int i = 2; i < n+1; i++) {
            System.out.println(answer[i]);
        }
    }
    static List<LinkedList<Integer>> al;
    static boolean visit[];
    static int[] answer;
    public static void dfs(int i, int before) {
        if(before != 0){
            answer[i] = before;
        }
        visit[i] = true;
        for(int j : al.get(i)) {
            if (visit[j] == false) {
                dfs(j, i);
            }
        }
    }
}
