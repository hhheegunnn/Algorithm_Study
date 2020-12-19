package boj구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_S1_14891_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
		for(int i=0; i < 4; i++) {
			list.add(new ArrayList<Character>());
		}
		
		for(int i=0; i < 4; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0; j < ch.length; j++) {
				list.get(i).add(ch[j]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i < K; i++) {
			String[] str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			int bang = Integer.parseInt(str[1]);
			boolean flag = false;
			if(bang == 1) {
				flag = true;
			}
			
			List<Character> change = list.get(num-1);
			
			int ind = 2;
			int next = num;
			int prev = num-2;
			List<Character> com = change;
			
			int count = 0;
			while(next <= list.size()-1) {
				if(com.get(ind) != list.get(next).get(8-ind)) {
					com = list.get(next);
					next+=1;
					count++;
				}else {
					break;
				}
			}
			
			next = num;
			//오른쪽
			while(count > 0) {
					//바꿔주는 과정
				if(!flag) {
					//반시계 -> 시계
					char re = list.get(next).remove(list.get(next).size()-1);
					list.get(next).add(0,re);
				}else {
					char re = list.get(next).remove(0);
					list.get(next).add(re);
				}
				com = list.get(next);
				next+=1;
				count--;
				flag = !flag;
			}
			
			ind = 6;
			com = change;
			count = 0;
			while(prev >= 0) {
				if(com.get(ind) != list.get(prev).get(8-ind)) {
					com = list.get(prev);
					prev -= 1;
					count++;
				}else {
					break;
				}
			}
			
			if(bang == 1) {
				flag = true;
			}else
				flag = false;
			
			//왼쪽
			prev = num-2;
			while(count > 0) {
				if(!flag) {
					char re = list.get(prev).remove(list.get(prev).size()-1);
					list.get(prev).add(0,re);
				}else {
					char re = list.get(prev).remove(0);
					list.get(prev).add(re);
				}
				prev -= 1;
				count--;
				flag = !flag;
			}
			
			if(bang == -1) {
				char re = change.remove(0);
				change.add(re);
				
			}else {
				char re = change.remove(change.size()-1);
				change.add(0,re);
			}
		}
		
		int ans = 0;
		if(list.get(0).get(0)-'0' == 1) {
			ans+=1;
		}
		if(list.get(1).get(0)-'0' == 1) {
			ans += 2;
		}
		if(list.get(2).get(0)-'0' == 1) {
			ans += 4;
		}
		if(list.get(3).get(0)-'0' == 1) {
			ans += 8;
		}
		System.out.println(ans);
	}

}
