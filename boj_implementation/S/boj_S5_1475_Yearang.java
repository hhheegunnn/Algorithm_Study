import java.util.Scanner;

public class boj_S5_1475_Yearang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int[] countList = new int[10];
        int answer = 0;
        int sixNine = 0;
        for (String tmp : n.split("")) {

            if (tmp.equals("6") || tmp.equals("9")) {
                countList[6]++;
                if (answer < countList[6] / 2 + countList[6] % 2) {
                    answer = countList[6] / 2 + countList[6] % 2;
                }
            } else {
                countList[Integer.parseInt(tmp)]++;
                if (answer < countList[Integer.parseInt(tmp)]) {
                    answer = countList[Integer.parseInt(tmp)];
                }
            }
        }
        System.out.println(answer);

    }
}
