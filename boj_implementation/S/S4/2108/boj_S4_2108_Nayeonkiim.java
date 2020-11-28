package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_S4_2108_Nayeonkiim {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		double total = 0;
		int maxx = -4001, minn = 4001;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num+4000]++;
			
			total += num;
			
			if(maxx < num) {
				maxx = num;
			}
			if(minn > num) {
				minn = num;
			}
		}
		
		boolean flag = false;
		int many = 0, idx = 0, manyAns = 0, count = 0, middle = 0;
		for(int i = minn+4000; i <= maxx+4000; i++) {
			if(count < (N+1)/2 && arr[i] > 0) {
				middle = i-4000;
				count+=arr[i];
			}
			
			if(arr[i] > many) {
				many = arr[i];
				idx = i;
			}
		}
		
		for(int i = minn+4000; i <= maxx+4000; i++) {
			if(many == arr[i] && i == idx) {
				manyAns = i-4000;
				flag = true;
			}
			else if(many == arr[i] && flag == true) {
				manyAns = i-4000;
				flag = false;
			}
		}
		
		System.out.println(Math.round((double)total/N));
		System.out.println(middle);
		System.out.println(manyAns);
		System.out.println(maxx - minn);
	}
}

