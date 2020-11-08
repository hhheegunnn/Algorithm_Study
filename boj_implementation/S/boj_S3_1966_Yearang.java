import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_S3_1966_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] answer = new int[test];
        for(int i = 0; i < test; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<int[]> queue = new LinkedList<>();
            for(int j = 0; j < n; j++) {
                int[] tmp = new int[2];
                tmp[0] = sc.nextInt();
                tmp[1] = j;
                queue.add(tmp);
            }
            int max = findMax(queue);
            int order = 1;
            while(true) {
                int[] tmpQ = queue.poll();
                if(max == tmpQ[0] && tmpQ[1] == m) {
                    answer[i] = order;
                    break;
                }
                if(max == tmpQ[0]) {
                    order++;
                    max = findMax(queue);
                } else {
                    queue.add(tmpQ);
                }
            }

        }

        for(int tmp : answer) {
            System.out.println(tmp);
        }

    }

    public static int findMax(Queue<int []> queue) {
        int max = 0;
        for(int[] tmp : queue) {
            if(tmp[0] > max) {
                max = tmp[0];
            }
        }
        return max;
    }
}
