import java.util.Scanner;

public class boj_S3_1748_Yearang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String strN = Integer.toString(n);
        int answer = 0;

        for(int i = 1; i <= strN.length() - 1; i++) {
            answer += 9*Math.pow(10, i-1)*i;
        }
        answer += strN.length()*(n + 1 - Math.pow(10, strN.length()-1));
        System.out.println(answer);




    }
}
