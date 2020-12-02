package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Re_boj_S2_5430_Nayeonkiim {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int k=0; k < T; k++) {
			char[] RD = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String strArr = br.readLine();
			
			//[,] 제거하기 위한 코드
			strArr = strArr.substring(1,strArr.length()-1);
			
			// 숫자만 list에 들어가게 됨.
			List<String> list = new ArrayList<>(Arrays.asList(strArr.split(",")));
			
			boolean flag = true, enter = true;
			for(int i=0; i < RD.length; i++) {
				if(RD[i] == 'R') {
					flag = !flag;
				}else if(RD[i] == 'D') {
					if(list.size() == 0 || n==0) {
						System.out.println("error");
						enter = false;
						break;
					}
					//flag가 true이면 앞에서 부터
					if(flag) {
						list.remove(0);
					//flag가 false이면 뒤에서 부터
					}else {
						list.remove(list.size()-1);
					}
				}
			}
			
			if(enter) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(flag) {
					for(int i=0; i < list.size(); i++) {
						sb.append(list.get(i) +",");
					}
					if(list.size() > 0)
						sb.setLength(sb.length()-1);
				}else {
					for(int i=list.size()-1; i >= 0; i--) {
						sb.append(list.get(i)+",");
					}
					if(list.size() > 0)
						sb.setLength(sb.length()-1);
				}
				
				sb.append("]");
				System.out.println(sb.toString());
			}
		}
	}
}
//주의할 것 : 들어오는 수가 항상 한자리가 아니다!! 
