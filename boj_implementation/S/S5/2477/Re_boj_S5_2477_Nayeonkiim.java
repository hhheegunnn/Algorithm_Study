package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_boj_S5_2477_Nayeonkiim {
	static String str = "";
	static int ans;
	static int total = 1;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] count = new int[5];
		num = new int[6];
		for(int i=0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ne = st.nextToken();
			count[Integer.parseInt(ne)] += 1;
			str += ne;
			int next = Integer.parseInt(st.nextToken());
			
			num[i] = next;
		}
		
		int[] two= new int[4];
		int k = 0;
		for(int i=1; i < 5; i++) {
			if(count[i] == 2) {
				two[k++] = i;
			}
		}
		
		if(two[0] == 1 && two[1] == 3) {
			find(1,3,2,4);
		}else if(two[0] == 2 && two[1] == 4) {
			find(2,4,1,3);
		}else if(two[0] == 2 && two[1] == 3) {
			find(3,2,1,4);
		}else if(two[0] == 1 && two[1] == 4) {
			find(4,1,2,3);
		}
		
		System.out.println((total-ans)*N);
	}

	private static void find(int first, int next, int gal, int sel) {
		
		for(int i=0; i < str.length(); i++) {
			if(i != str.length()-1) {
				if(str.charAt(i)-'0' == first && str.charAt(i+1)-'0' == next) {
					ans = num[i]*num[i+1];
				}
			}else {
				if(str.charAt(i)-'0' == first && str.charAt(0)-'0' == next) {
					ans = num[i]*num[0];
				}
			}
			
			if(str.charAt(i)-'0' == gal) {
				total *= num[i];
			}else if(str.charAt(i)-'0' == sel)
				total *= num[i];
		}
	}

}

//간단한 풀이,,,와우
/*
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	
	int[] a = new int[6];
	int[] b = new int[6];
	int k=0, sum=0, max=0;
	
	for(int i=0; i < 6; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		a[i] = Integer.parseInt(st.nextToken());
		b[i] = Integer.parseInt(st.nextToken());
	}
	for(int i=0; i < 6; i++) {
		if(max < b[i]*b[(i+1)%6])
		{
			max = b[i]*b[(i+1)%6];
			k=i;
		}
	}
	
	//항상 가로의 최댓값의 index를 k라고 한다면 k+3,k+4 를 곱한게 작은 직사각형이 된다.
	sum = b[(k+3)%6]*b[(k+4)%6];
	max=max-sum;
	System.out.println(max*N);
}
*/
