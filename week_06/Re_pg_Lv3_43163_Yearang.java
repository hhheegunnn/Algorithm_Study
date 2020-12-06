import java.util.*;

public class pg_Lv3_43163_Yearang {
    public static void main(String[] args) {
        String[] target =  {"hot", "dot", "dog", "lot", "log", "cog"};
        int an = solution("hit", "cog", target);
        System.out.println(an);

    }
    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        targt = target;
        visit = new boolean[words.length];
        int tmpA = 0;
        for(int i = 0; i < words.length; i++) {
            visit = new boolean[words.length];
            dfs(begin, words, i, 0);
        }
        return answer == 0 ? answer : answer -1;
    }

    static boolean[] visit;
    static String targt;
    static int answer;
    public static void dfs(String word, String[] words, int idx, int tmpA) {
        tmpA++;
        System.out.print (word + " ");
        if(word.equals(targt)){
            if(answer == 0) {
                answer = tmpA;
            } else if(tmpA < answer) {
                answer = tmpA;
                System.out.println();
            }
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(visit[i] != true && check(word, words[i])) {
                visit[i] = true;
                dfs(words[i], words, i + 1, tmpA);
                System.out.println();
                visit[i] = false;
            }
        }

    }
    public static boolean check(String w1, String w2) {
        String[] w1t = w1.split("");
        String[] w2t = w2.split("");
        int count = 0;
        for(int i = 0; i < w1t.length; i++) {
            if(!w1t[i].equals(w2t[i])) {
                count++;
                if(count > 1) {
                    return false;
                }
            }
        }
        return count==1 ? true : false;
    }
}
