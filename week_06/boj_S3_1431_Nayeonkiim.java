package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_S3_1431_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		for(int i=0; i < N; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1total=0, o2total = 0;
				if(o1.length() < o2.length()) {
					return -1;
				}else if(o1.length() == o2.length()) {
					for(int i=0; i < o1.length(); i++) {
						if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
							o1total += o1.charAt(i)-'0';
						}
						if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
							o2total += o2.charAt(i)-'0';
						}
					}
					
					if(o1total < o2total) {
						return -1;
					}else if(o1total == o2total) {
						int ret = 0;
						for(int i=0; i < o1.length(); i++) {
							if(o1.charAt(i) == o2.charAt(i)) {
								continue;
							}else if(o1.charAt(i) < o2.charAt(i)){
								ret = -1;
								break;
							}else {
								ret = 1;
								break;
							}
						}
						if(ret == 1) {
							return 1;
						}
						return -1;
						
					}else {
						return 1;
					}
					
				}else {
					return 1;
				}
			}
			
		});
		
		for(int i=0; i < N; i++) {
			System.out.println(arr[i]);
		}
    }	
}