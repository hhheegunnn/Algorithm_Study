package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_S1_2564_Nayeonkiim {
	
	public static class Point {
		int y;
		int x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int gal = Integer.parseInt(input[0]);
		int se = Integer.parseInt(input[1]);
		int count = Integer.parseInt(br.readLine());
		

		List<Point> list = new ArrayList<Point>();
		for(int i=0; i <= count; i++) {
			String[] str = br.readLine().split(" ");
			int y = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			
			if(y == 1) {
				Point p = new Point(0,x);
				list.add(p);
			}else if(y == 2) {
				Point p = new Point(se,x);
				list.add(p);
			}else if(y == 3) {
				Point p = new Point(x,0);
				list.add(p);
			}else if(y == 4) {
				Point p = new Point(x,gal);
				list.add(p);
			}
		}
		
		int total = 0;
		Point dong = list.get(list.size()-1);
		for(int i=0; i < count; i++) {
			if(Math.abs(dong.y- list.get(i).y) == se) {
				total += Math.min(dong.x + list.get(i).x + se,
						(gal - dong.x) + (gal - list.get(i).x) + se);
			}else if(Math.abs(dong.x- list.get(i).x) == gal) {
				total += Math.min(dong.y + list.get(i).y + gal,
						(se - dong.y) + (se - list.get(i).y) + gal);
			}else {
				total += Math.abs(dong.y - list.get(i).y) + Math.abs(dong.x - list.get(i).x);
			}
		}
		System.out.println(total);
	}
}

