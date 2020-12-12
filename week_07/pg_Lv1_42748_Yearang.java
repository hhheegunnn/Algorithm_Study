import java.util.Arrays;

public class pg_Lv1_42748_Yearang {
    public static void main(String[] args) {
        int[] t1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(t1, c);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for(int i = 0; i < commands.length; i++) {
            int [] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
//            System.out.println(answer[i]);
        }


        return answer;
    }
}
