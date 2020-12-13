package boj구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class boj_S1_1713_Nayeonkiim {
	
	public static class Student {
		int num;
		int count;
		int order;
		Student(int num, int count, int order){
			this.num = num;
			this.count = count;
			this.order = order;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int chu = Integer.parseInt(bf.readLine());
		
		List<Student> list = new ArrayList<Student>();
		
		String[] str = bf.readLine().split(" ");
		for(int i=0; i < chu; i++) {
			int st = Integer.parseInt(str[i]);
			
			if(list.size() == N) {
				boolean flag = calc(list,st);
				if(!flag) {
					list.remove(0);
					list.add(new Student(st,1,i));
				}
			}else {
				//que에 공간이 있는 경우
				boolean flag = calc(list,st);
				if(!flag) {
					list.add(new Student(st,1,i));
				}
			}
			sortt(list);
		}
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.num < o2.num) {
					return -1;
				}else if(o1.num > o2.num) {
					return 1;
				}else
					return 0;
			}
		});
		
		
		for(int i=0; i < list.size(); i++) {
			System.out.print(list.get(i).num + " ");
		}
	}

	private static boolean calc(List<Student> list, int st) {
		int flag = -1;
		for(int j=0; j<list.size(); j++){
			if(list.get(j).num == st) {
				flag = j;
				break;
			}
		}
		
		if(flag != -1) {
			Student student = list.remove(flag);
			list.add(flag,new Student(student.num,student.count+1,student.order));
			return true;
		}else
			return false;
	}
	
	private static void sortt(List<Student> list) {
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.count < o2.count) {
					return -1;
				}else if(o1.count > o2.count) {
					return 1;
				}else {
					if(o1.order < o2.order) {
						return -1;
					}else {
						return 1;
					}
				}
			}
		});
	}
}