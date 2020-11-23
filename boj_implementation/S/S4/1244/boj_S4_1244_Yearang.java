import java.util.Scanner;

public class boj_S4_1244_Yearang {

    public static int[] swich;
    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        swich = new int[n];
        for (int i = 0; i < n; i++) {
            swich[i] = sc.nextInt();
        }

        int pn = sc.nextInt();
        for (int i = 0; i < pn; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();
            if (gender == 1) { // 남자
                boyChange(num);
            } else {
                girlChange(num - 1);
            }
        }
        int row = 0;
        for (int tmp : swich) {
            System.out.print(tmp + " ");
            row++;
            if(row == 20) {
                System.out.println();
                row = 0;
            }
        }

    }

    public static void girlChange(int idx) {
        int i = 1;
        while (idx - i >= 0 && idx + i < n) {
            if (swich[idx - i] != swich[idx + i]) {
                break;
            } else {
                swich[idx - i] = swich[idx - i] == 0 ? 1 : 0;
                swich[idx + i] = swich[idx + i] == 0 ? 1 : 0;
            }
            i++;
        }
        swich[idx] = swich[idx] == 0 ? 1 : 0;
    }

    public static void boyChange(int idx) {
        int i = 1;
        while (idx * i - 1 < n) {
            swich[idx * i - 1] = swich[idx * i - 1] == 0 ? 1 : 0;
            i++;
        }
    }
}
