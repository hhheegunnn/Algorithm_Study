package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Re_S2_4307_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cas = Integer.parseInt(br.readLine());
		
		for(int i=0; i <  cas; i++) {
			String[] str = br.readLine().split(" ");
			int mak = Integer.parseInt(str[0]);
			int amount = Integer.parseInt(str[1]);
			
			int[] ant = new int[amount];
			for(int j=0; j < amount; j++) {
				ant[j] = Integer.parseInt(br.readLine());  
			}
			
			int minn = 0, maxx = 0, com = 0; 
			int mid = (int)mak/2;
			for(int j=0; j < amount; j++) {
				if(ant[j] == 0 || ant[j] == mak) {
					com = 0;
				}else if(ant[j] >= mid) {
					com = mak-ant[j];
				}else { 
					com = ant[j];
				}
				//각 개미들의 최소 이동거리 중 최대값
				minn = Math.max(minn, com);
			}
			
			Arrays.sort(ant);
			maxx = Math.max(mak-ant[0], ant[ant.length-1]);
			
			System.out.println(minn+" "+maxx);
		}
	}
}
