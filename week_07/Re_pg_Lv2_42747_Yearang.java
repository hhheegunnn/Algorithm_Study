import java.util.Arrays;

public class pg_Lv2_42747_Yearang {
    public static void main(String[] args) {
        int[] c = {3, 0, 6, 1, 5};
        System.out.println(solution(c));
    }
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i = 0; i < citations[citations.length-1]; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
                return h;
            }
        }
        return answer;
    }
}
