import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class boj_S3_17413_Yearang {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] arr = s.split("");
        boolean tag = false;
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i];
            if(tmp.equals(" ") && !tag) {
                while(!stack.isEmpty()) {
                    answer += stack.pop();
                }
                answer += tmp;

            } else if (tmp.equals("<")) {
                while(!stack.isEmpty()) {
                    answer += stack.pop();
                }
                answer += tmp;
                tag = true;
            } else if (tmp.equals(">")) {
                answer += tmp;
                tag = false;
            } else if (tag) {
                answer += tmp;
            } else {
                stack.add(tmp);
            }
        }

//        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                answer += stack.pop();
            }
//        }

        System.out.println(answer);
    }
}
