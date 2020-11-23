package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Re_boj_S2_2504_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String gal = br.readLine();
		Stack<String> stack = new Stack<>();
		
		boolean isAble = true;
		for(int i=0; i < gal.length(); i++) {
			 String c = gal.substring(i, i+1);
			 
			 if("(".equals(c)){
				 stack.push(")");
				 continue;
			 }
			 
			 if("[".equals(c)) {
				 stack.push("]");
				 continue;
			 }
			 
			 int num = 0;
			 while(true) {
				 if(stack.isEmpty()) {
					 isAble = false;
					 break;
				 }
				 
				 if(isNumber(stack.peek())) {
					 num += Integer.parseInt(stack.pop());
				 }else {
					 if(isVPS(c,stack.peek())){
						 stack.pop();
						 int t =(")".equals(c)) ? 2:3;
						 
						 if(num == 0) {
							 stack.push(String.valueOf(t));
						 }else {
							 stack.push(String.valueOf(t*num));
						 }
						 break;
					 }else {
						 isAble = false;
						 break;
					 }
				 }
			 }
			 if(!isAble) break;
		}
		
		int result = 0;
		
		while(!stack.isEmpty()) {
			if(isNumber(stack.peek())) {
				result += Integer.parseInt(stack.pop());
			}else{
				isAble = false;
				break;
			}
		}
		if(isAble) System.out.println(result);
		else System.out.println(0);
	}

	//스택의 괄호와 target이 동일한 경우
	private static boolean isVPS(String c, String target) {
		if(c.equals(target)) return true;
		return false;
	}

	//peek한 값이 괄호가 아니면 숫자!!
	private static boolean isNumber(String str) {
		if(str.equals(")") || str.equals("]")) return false;
		
		return true;
	}
}
