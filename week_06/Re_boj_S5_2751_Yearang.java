import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S5_2751_Yearang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        for (int t : al) {
            sb.append(t + "\n");
        }
        System.out.println(sb);
    }
}
