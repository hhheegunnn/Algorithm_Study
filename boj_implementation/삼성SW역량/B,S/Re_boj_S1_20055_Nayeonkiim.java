package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Re_boj_S1_20055_Nayeonkiim {
    public static int[] num; //내구도
    public static boolean[] robot;
    public static int left;
    public static int right;
    public static int N,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //벨트의 길이
        k = Integer.parseInt(st.nextToken());  //갯수

        num = new int[2*N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < 2*N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        left = 0;
        right = N;

        int count=0;
        while(k > 0){
            count++;
            moveBelt();
            moveRobot();
            addRobot();
        }
        System.out.println(count);
    }

    private static void addRobot() {
        if(!robot[0] && num[left] > 0){
            robot[0] = true;
            num[left] -= 1;
            if(num[left] == 0){
                k--;
            }
        }
    }

    private static void moveRobot() {
        for(int i=N-2; i>=0; i--) {
            if(robot[i]) {
                int next = left + i + 1;
                if(next >= 2*N)
                    next -= 2*N;
                if (!robot[i + 1] && num[next] > 0) {
                    robot[i] = false;
                    if (i+1 < N - 1) {
                        robot[i + 1] = true;
                    }
                    num[next] -= 1;
                    if(num[next] == 0){
                        k--;
                    }
                }
            }
        }
    }

    private static void moveBelt() {
        left--;
        if(left == -1){
            left = 2*N-1;
        }
        right--;
        if(right == -1){
            right = 2*N-1;
        }
        for(int i = N-2; i >= 0; i--){
            //로봇이 존재한다면
            if(robot[i]) {
                robot[i] = false;
                if(i+1 < N-1){
                    robot[i+1] = true;
                }
            }
        }
    }
}
