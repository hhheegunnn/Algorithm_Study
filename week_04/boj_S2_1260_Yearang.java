import java.util.*;

public class boj_S2_1260_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 정점의 개수
        int m = sc.nextInt();   // 간선의 개수
        int v = sc.nextInt();   // 시작 정점

        // 초기화
        ad = new ArrayList<>();
        for(int i = 0 ;i < n+1; i++) {
            ad.add(new ArrayList<>());
        }
        visit = new boolean[n+1];

        // 간선 추가
        for(int i =0; i < m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }
        try {
            for (int i = 0; i < m + 1; i++) {
                ad.get(i).sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        } catch (Exception e){

        }

        dfs(v);
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);

    }

    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ad;

    public static void dfs(int i){
        visit[i] = true;
        System.out.print(i + " ");

        for(int j : ad.get(i)){  // 배열 null check
            if(visit[j] == false){
                dfs(j);
            }
        }
    }

    public static void bfs(int i){
        Queue<Integer> q = new <Integer>LinkedList();
        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();

        q.offer(i);

        while(!q.isEmpty()){
            int temp = q.poll();
            visit[temp] = true;
            System.out.print(temp + " ");

            for(int j : ad.get(temp)){
                if(visit[j] == false && !hash.containsKey(j)){
                    q.offer(j);
                    hash.put(j, true);
                }
            }

        }
    }


}
