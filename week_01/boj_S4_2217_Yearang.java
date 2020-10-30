import java.util.Arrays;
import java.util.Scanner;
public class boj_S4_2217_Yearang {
        public static void main(String[] arg) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // 정렬
            Arrays.sort(arr);
            int weight = 0;
            int answer = 0;
            int count = 0;

            for (int i = arr.length - 1; i >= 0; i--) {
                count++;
                int tmpW = arr[i] * count;
                if (weight < tmpW) {
                    weight = tmpW;
                }
            }
            System.out.println(weight);
        }
}
