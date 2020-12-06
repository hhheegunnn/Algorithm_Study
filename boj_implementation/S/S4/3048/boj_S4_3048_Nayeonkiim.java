package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_S4_3048_Nayeonkiim {
	public static class Ant{
		int group;
		char dan;
		Ant(int group, char dan){
			this.group = group;
			this.dan = dan;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		char[] N1Gro = br.readLine().toCharArray();
		char[] N2Gro = br.readLine().toCharArray();
		ArrayList<Ant> list = new ArrayList<>();
		
		for(int i=N1Gro.length-1; i >= 0; i--) {
			list.add(new Ant(1,N1Gro[i]));
		}
		for(int i=0; i < N2Gro.length; i++) {
			list.add(new Ant(2,N2Gro[i]));
		}
		
		int after = Integer.parseInt(br.readLine());
		
		int count =0, k = 0;
		StringBuilder sb= new StringBuilder();
		while(count < after) {
			//마지막 대문자의 인덱스 
			for(int i=0; i < list.size()-1; i++) {
				if(list.get(i).group == 1 && list.get(i).group != list.get(i+1).group) {
					Ant rem = list.remove(i);
					list.add(i+1,rem);
					i+=1;
				}
			}
			count++;
		}
		
		for(Ant a : list){
			sb.append(a.dan);
		}
		System.out.println(sb);
	}
}
