import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class boj_S3_1431_Yearang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length()-o2.length();
                } else {
                    String[] tmp1 = o1.split("");
                    String[] tmp2 = o2.split("");
                    int num1 = 0, num2 = 0;
                    for(String t : tmp1) {
                        if(isDigit(t)){
                            num1 += Integer.parseInt(t);
                        }
                    }
                    for(String t : tmp2) {
                        if(isDigit(t)){
                            num2 += Integer.parseInt(t);
                        }
                    }
                    if(num1 != num2) {
                        return num1 - num2;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        for(String t : list) {
            System.out.println(t);
        }


    }
    static boolean isDigit(String s) {
        try {
            int n= Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
