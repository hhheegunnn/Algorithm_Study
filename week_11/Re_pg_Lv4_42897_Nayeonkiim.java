package week11;

public class Re_pg_Lv4_42897_Nayeonkiim {
    //인접한 두집을 털면 경보가 울린다
    public static int solution(int[] money) {
        int answer = 0;
        int length = money.length;
        //한개는 처음 집을 훔치는 경우, 다른 한개는 처음 집을 훔치지 않는 경우
        int[] dp = new int[length-1];
        int[] dp2 = new int[length];

        //dp 배열은 처음 집을 훔치는 경우이므로
        dp[0] = money[0];
        dp[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        //처음 집을 훔치기 때문에 인접한 마지막 집은 훔칠 수 없으므로 반복문은 length-1 전까지만 돈다.
        for(int i=2; i < length-1; i++) {
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        }
        for(int i=2; i < length; i++) {
            dp2[i] = Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }

        //두 배열의 각각 마지막 값 비교해서 큰 값이 답이 된다.
        return Math.max(dp[length-2],dp2[length-1]);
    }

    public static void main(String[] args) {
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }
}
