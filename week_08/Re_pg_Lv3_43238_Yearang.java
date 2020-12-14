import java.util.Arrays;

public class pg_Lv3_43238_Yearang {

    public static void main(String[] args) {
        int[] t = {2,2};
        System.out.println(solution(1, t));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = (long)times[0] * n;
        long right = (long)times[0] * n;
        long left = 1;

        long count;
        long mid = (right + left) / 2;

        while (left <= right) {
            count = 0;
            for (int t : times) {
                count += (mid / (long)t);
            }

            if (count >= (long)n) {
                right = mid - 1;
                answer = answer > mid ? mid : answer;
                mid = (right + left) / 2;
            } else if (count < (long)n) {
                left = mid + 1;
                mid = (right + left) / 2;
            }
        }
        return answer;
    }
}