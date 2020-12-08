package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Re_boj_S1_2110_Nayeonkiim {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		
		int[] a = new int[n];
		for(int i=0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		int ans = 1;
		int l = 1;
		int r = a[n-1];
		while(l <= r) {
			//mid는 인접한 두 공유기 사이의 거리
			int mid = (l+r)/2;
			if(possible(a,c,mid)) {
				ans = Math.max(ans, mid);
				l = mid+1;
			}else {
				r = mid-1;
			}
		}
		System.out.println(ans);
	}

	//mid 만큼 거리 유지한채 c만큼의 공유기 설치가 가능한지 확인
	private static boolean possible(int[] a, int c, int mid) {
		int cnt = 1;
		int last = a[0];
		for(int house : a) {
			if(house - last >= mid) {
				cnt += 1;
				last = house;
			}
		}
		return cnt >= c;
	}
}
