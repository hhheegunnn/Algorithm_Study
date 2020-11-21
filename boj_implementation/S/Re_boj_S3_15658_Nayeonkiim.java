package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Re_boj_S3_15658_Nayeonkiim {

	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] a = new int[N];
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		String[] strp = br.readLine().split(" ");
		
		go(a,1,a[0],Integer.parseInt(strp[0]),Integer.parseInt(strp[1]),Integer.parseInt(strp[2]),Integer.parseInt(strp[3]));
		int maxx = -1000000000, minn = 1000000000;
		
		for(int i=0; i < list.size(); i++) {
			maxx = Math.max(maxx, list.get(i));
			minn = Math.min(minn, list.get(i));
		}
		System.out.println(maxx);
		System.out.println(minn);
	}

	private static void go(int[] a, int index, int total, int sum, int minus, int mul, int div) {
		
		if(index == a.length) {
			list.add(total);
			return;
		}
		
		if(sum > 0)
			go(a,index+1,total+a[index],sum-1,minus,mul,div);
		if(minus > 0)
			go(a,index+1,total-a[index],sum,minus-1,mul,div);
		if(mul > 0)
			go(a,index+1,total*a[index],sum,minus,mul-1,div);
		if(div > 0)
			go(a,index+1,total/a[index],sum,minus,mul,div-1);
	}
}