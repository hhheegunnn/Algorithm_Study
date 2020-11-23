import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj_S5_1316_Yearang {

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
            String[] tmp = new String[words[i].length()];
            tmp = words[i].split("");
            Set<String> duplCheck = new HashSet<String>();
            String before = "";
            boolean flag = true;
            for(String t : tmp) {
                if(before.equals(t)) {
                    continue;
                } else if(duplCheck.contains(t)) {
                    flag = false;
                    break;
                } else {
                    before = t;
                    duplCheck.add(t);
                }
            }
            if(flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
