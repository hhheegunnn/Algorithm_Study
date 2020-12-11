package week7;

import java.util.Arrays;
import java.util.Comparator;

public class pg_lv1_42748_Nayeonkiim {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; i< commands.length; i++) {
			
			String str = "";
			
			for(int n=commands[i][0]-1; n < commands[i][1]; n++) {
				str += array[n]+" ";
			}
			String[] strArray = str.split(" ");
			
			Arrays.sort(strArray, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(Integer.parseInt(o1) < Integer.parseInt(o2))
						return -1;
					else if(Integer.parseInt(o1) > Integer.parseInt(o2))
						return 1;
					else
						return 0;
				}
			});
		
			answer[i] = Integer.parseInt(strArray[commands[i][2]-1]);
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		pg_lv1_42748_Nayeonkiim a = new pg_lv1_42748_Nayeonkiim();
		for(int i=0; i < a.solution(array, commands).length; i++)
			System.out.println(a.solution(array, commands)[i]);
	}
}
