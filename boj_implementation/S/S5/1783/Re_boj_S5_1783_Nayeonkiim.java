package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S5_1783_Nayeonkiim {
    static int ans =0;
    public static void main(String args[]) throws IOException {
        //세로,가로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //세로
        int M = Integer.parseInt(st.nextToken());  //가로

        if(N == 1){
            System.out.println(1);
            return;
        }
        else if(N == 2) {
            ans = Math.min(4,(M+1)/2);
        }else{
            if(M >= 7){
                ans = (M-7)+5;
            }else{
                ans = Math.min(4,M);
            }
        }
        System.out.println(ans);
    }
}
