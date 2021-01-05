package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_S5_2998_Nayeonkiim {
	public static String[] arr = { "000","001","010","011","100", "101", "110", "111"};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int count = 0;
		int n = N.length();
		while(n%3 != 0) {
			count++;
			n++;
		}
		
		String newStr = "";
		for(int i=0; i < count; i++) {
			newStr += '0';
		}
		newStr += N;
		
		String ans = "";
		int num = newStr.length();
		String fake = newStr;
		for(int i=0; i < num; i+=3) {
			String s = fake.substring(i,i+3);
			for(int j=0; j < 8; j++) {
				if(s.equals(arr[j])) {
					ans += j;
					break;
				}
				
			}
			fake = newStr;
		}
		System.out.println(ans);
	}
}
