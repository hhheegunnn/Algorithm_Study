import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S1_11286_Yearang {
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
//        int n = s.nextInt();
//
//        TreeSet<Double> tm = new TreeSet<>(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return o1.compareTo(o2);
//            }
//        });

        PriorityQueue<Double> tm = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                Double o11= Math.abs(o1);
                Double o22= Math.abs(o2);
                if(o11.compareTo(o22) == 0) {
                    return o1.compareTo(o2);
                }
                return o11.compareTo(o22);
            }
        });

        for(int i = 0; i < n; i++) {
            Double tmp = Double.parseDouble(reader.readLine());
            if(tmp != 0) {
                tm.add(tmp);
            } else {
                if(tm.size() > 0) {
                    Double fe = tm.poll();
                    System.out.println(Math.round(fe));
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
