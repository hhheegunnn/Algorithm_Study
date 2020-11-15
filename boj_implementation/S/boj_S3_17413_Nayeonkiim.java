package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_S3_17413_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<String> list = new ArrayList<>();
		
		int i = 0, j = 0;
		int k = 0;
		while(i < str.length()) {
			if(str.charAt(i) == '<') {
				for(j=i+1; j<str.length(); j++) {
					if(str.charAt(j) == '>') {
						list.add(str.substring(i,j+1));
						break;
					}
				}
				i = j+1;
			}else if(str.charAt(i) == ' ') {
				i++;
				list.add(" ");
				continue;
			}else {
				for(j = i; j < str.length(); j++) {
					if(str.charAt(j) == '<' || str.charAt(j) == ' ') {
						break;
					}else {
						continue;
					}
				}
				list.add(str.substring(i,j));
				i = j;
			}
		}
		
		for(int m=0; m<list.size();m++) {
			if(list.get(m).charAt(0) != '<') {
				String rem = list.remove(m);
				String addd="";
				for(int n=rem.length()-1; n>=0;n--) {
					addd+=rem.charAt(n);
				}
				list.add(m,addd);
			}
		}
		
		for(int m=0; m<list.size();m++) {
			System.out.print(list.get(m));
		}
	}
	
}
