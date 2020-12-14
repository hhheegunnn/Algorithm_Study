import java.util.Arrays;
import java.util.Scanner;

public class boj_S4_10815_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cards = new long[n];

        for(int i = 0; i < n; i++) {
            cards[i] = sc.nextLong();
        }
        int m = sc.nextInt();
        int [] answer = new int[m];
        long[] sangCards = new long[m];
        for(int i = 0; i < m; i++) {
            sangCards[i] = sc.nextLong();
        }

        /* [검색]
        *1. for 문 : O(n)
        *2. 이분탐색 : O(log(n))
        1.이분 탐색을 하고자 할 때 이미 정렬이 되어있어야 합니다.
        2. left, right로 미드값을 잡아줍니다.
        3. mid 값과 구하고자 하는 값을 비교 합니다.
        4. 비교할시 mid 값보다 구하고자 하는 값이 높으면 left를 mid+1로 만들어주고 낮으면 right를 mid-1로 만들어 줍니다.
        5. left > right 가 될때까지 1~3번을 반복해서 구하고자 하는 값을 찾습니다
         */

        // 1. 정렬
        Arrays.sort(cards);

        // 2. left, right, mid
        int left = 0;
        int right = cards.length-1;
        int mid = (left + right)/2;

        // 3. 비교
        for(int i = 0; i < sangCards.length; i++) {
            long find = sangCards[i];
            left = 0;
            right = cards.length-1;
            mid = (left + right)/2;
            while (left <= right) {
                if (cards[mid] > find) {
                    right = mid - 1;
                    mid = (left + right)/2;
                } else if (cards[mid] < find) {
                    left = mid + 1;
                    mid = (left + right)/2;
                } else { // 같으면
                    answer[i] = 1;
                    break;
                }
            }
        }

        for(int t : answer) {
            System.out.print(t + " ");
        }
//        System.out.println(Arrays.toString(answer));
    }
}
