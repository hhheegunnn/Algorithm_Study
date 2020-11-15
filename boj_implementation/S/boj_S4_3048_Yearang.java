import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S4_3048_Yearang {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n1 = Integer.parseInt(reader.readLine());
//        int n2 = Integer.parseInt(reader.readLine());
        reader.readLine();

        String ant1 = reader.readLine();
        String ant2 = reader.readLine();
        int t = Integer.parseInt(reader.readLine());

        int n1 = ant1.length();
        int n2 = ant2.length();

        String[] ant1Arr = ant1.split("");
        String[] ant2Arr = ant2.split("");

        List<String[]> ants = new ArrayList<>();

        for(int i = n1-1; i >= 0; i--) {
            String[] tmp = {ant1Arr[i], "1"};   // 왼 -> 오
            ants.add(tmp);
        }
        for(int i = 0; i < n2; i++) {
            String[] tmp = {ant2Arr[i], "-1"};
            ants.add(tmp);
        }

        for(int i = 0 ; i < t; i++) {
            Set<String> dupl = new HashSet<>();
            for(int j = 0 ; j < ants.size()-1; j++) {
                if(ants.get(j)[1].equals("1") && ants.get(j+1)[1].equals("-1") && !dupl.contains(ants.get(j)[0]) && !dupl.contains(ants.get(j+1)[0])) {

                    dupl.add(ants.get(j)[0]);
                    dupl.add(ants.get(j+1)[0]);

                    // swap
                    String[] tmp = ants.get(j);
                    ants.set(j, ants.get(j+1));
                    ants.set(j+1, tmp);
                }
            }
        }

        for(String[] tmp : ants){
            System.out.print(tmp[0]);
        }


    }

}
