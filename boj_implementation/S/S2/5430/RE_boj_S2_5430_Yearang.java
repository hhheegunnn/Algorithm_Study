import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_S2_5430_Yearang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[","").replace("]","").split(",");
            List<Integer> arrList = new ArrayList<>();

            if(n > 0) {
                for (String tmp : arr) {
                    arrList.add(Integer.parseInt(tmp));
                }
            }

            int direction = 0;  // 0 : 왼 -> 오 1: 오 -> 왼
            int startIdx = 0;
            int endIdx = arrList.size()-1;

            boolean isError = false;
            for(String tp : p) {
                if(tp.equals("R")) {
                    direction = direction == 0 ? 1 : 0;
                } else {
                    if(n == 0) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if(startIdx > endIdx) {
                        System.out.println("error");
                        isError = true;
                        break;
                    } else {
                        if(direction == 0) {
                            startIdx++;
                        } else {
                            endIdx--;
                        }
                        n--;
                    }
                }
            }

            if(!isError) {
                StringBuilder answer = new StringBuilder();
                if(n == 0 ) {
                    System.out.println("[]");
                    continue;
                }
                answer.append("[");
                if(direction == 0) {
                    for (int j = startIdx; j <= endIdx; j++) {
                        answer.append(arrList.get(j));
                        answer.append(",");
                    }
                } else {
                    for (int j = endIdx; j >= startIdx; j--) {
                        answer.append(arrList.get(j));
                        answer.append(",");
                    }
                }
                answer.deleteCharAt(answer.length()-1);
                answer.append("]");
                System.out.println(answer);
            }
        }
    }

}
