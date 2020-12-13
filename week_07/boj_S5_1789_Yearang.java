import java.util.Scanner;

public class boj_S5_1789_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

        int answer = 0, num = 1;
        long sum = 0L;
        while(sum <= s) {
            answer++;
            sum += num;
            num++;
        }

        System.out.println(answer-1);

    }

}
