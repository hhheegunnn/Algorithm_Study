import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_S2_1913_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int[] tmp = {sc.nextInt(), sc.nextInt()};
            list.add(tmp);
        }

        // 끝나는 시간 기준 오름차순
        list.sort(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {    // 같은경우 시작시간 기준 오름차
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int end = 0;

        for(int[] tmp : list) {
            if(end <= tmp[0]) {
                end = tmp[1];
                answer++;
            }
        }

        System.out.println(answer);

    }
}
