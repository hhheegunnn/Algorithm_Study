package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_boj_S4_2670_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double[] a = new double[N];
		for(int i=0; i < N; i++) {
			a[i] = Double.parseDouble(br.readLine());
		}
		
		double[] d= new double[N];
		d[0] = a[0];
		for(int i=1; i < N; i++) {
			d[i] = Math.max(d[i-1]*a[i], a[i]);
		}
		
		double ans = d[0];
		for(int i=0; i < N; i++) {
			if(ans < d[i])
				ans = d[i];
		}
		
		//소수점 3번째 자리까지 반올림하기 -> %.3f
		System.out.printf("%.3f", ans);
	}
}
