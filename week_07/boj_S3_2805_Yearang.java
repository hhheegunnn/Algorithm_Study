import java.util.Scanner;

public class boj_S3_2805_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] tree = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextLong();
            if (tree[i] > max) {
                max = tree[i];
            }
        }


        long left = 1, right = max, mid = (left + right) / 2;
        long answer = 0;
        while (left <= right) {
            long sum = 0;
            for(long t : tree) {
                sum += t > mid ? t - mid : 0;
            }
            if(sum < m) {
                right = mid -1;
                mid = (left + right) / 2;
            } else if (sum > m) {
                answer = mid > answer ? mid : answer;
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                answer = mid;
                break;
            }
        }
        System.out.println(answer);

    }
}


