package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_S4_10989_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[10001];
		for(int i=0; i < N; i++) {
			list[Integer.parseInt(br.readLine())]++;
		}
		
		int count = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1; i < list.length; i++) {
			if(list[i] > 0) {
				for(int j=0; j < list[i]; j++) {
					bw.write(i + "\n");
					count++;
				}
			}
			
			if(count == N) {
				break;
			}
		}
		bw.flush();
	}
}
