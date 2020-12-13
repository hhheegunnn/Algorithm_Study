import java.util.Arrays;
import java.util.Comparator;

public class pg_Lv2_42746_Yearang {
    public static void main(String[] args) {

        int[] t1 = {6, 10, 2};
        int[] t2 = {3, 30, 34, 5, 9};
        solution(t2);

    }
    public static String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        String[] numStr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numStr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return (o1+o2).compareTo((o2+o1));
                }
            }
        });

        int zero = 0;
        for(int i = numStr.length-1; i >= 0; i--) {
            answer.append(numStr[i]);
            if(numStr[i].equals("0")) {
                zero++;
            }
        }

        if(zero == numStr.length) {
            return "0";
        }
//        System.out.println(answer.toString());
        return answer.toString();
    }
}
