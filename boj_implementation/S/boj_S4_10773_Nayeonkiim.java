package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj_S4_10773_Nayeonkiim {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int n = sc.nextInt();
		int total = 0;
		
		for(int i=0;i<n;i++) {
			int next = sc.nextInt();
			if(next == 0) {
				stack.pop();
			}else
				stack.add(next);
		}
		
		for(int st : stack) {
			total += st;
		}
		
		System.out.println(total);
	}
}