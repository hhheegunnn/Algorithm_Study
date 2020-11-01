package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//내가 푼 답 : 시간 초과
public class Re_boj_S2_1931_Nayeonkiim {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.MAX_VALUE;
		List<List<Integer>> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		int minn = Integer.MAX_VALUE, count = 1;
		int curIdx = 0;
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.get(i).add(Integer.parseInt(st.nextToken()));
			list.get(i).add(Integer.parseInt(st.nextToken()));
			if(minn > list.get(i).get(1)) {
				minn = list.get(i).get(1);
				curIdx = i;
			}
		}
		
		int idx = 0;
		while(curIdx < N-1) {
			idx = small(list, minn, s, curIdx);
			if(idx == -1)
				break;
			count++;
			minn = list.get(idx).get(1);
			curIdx = idx;
		}
		System.out.println(count);
	}

	private static int small(List<List<Integer>> list, int minn, int s, int curIdx) {
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get(0) >= minn && i != curIdx) {
				if(s > list.get(i).get(1)) {
					s = list.get(i).get(1);
					curIdx = i;
				}
			}
		}
		return curIdx;
	}
	
	
	// 답 - 종료시간 기준으로 정렬 후 count
	public static int answer() throws Exception, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 종료시간 기준 작은 걸로 정렬, 만약 같은 경우 시작시간 기준
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] +" " +arr[i][1]);
		}
		
		int end = arr[0][1], count = 1;
		for(int i = 1; i < N; i++) {
			if(arr[i][0] >= end) {
				count++;
				end = arr[i][1];
			}
		}
		//System.out.println(count);
		return count;
	}
}



