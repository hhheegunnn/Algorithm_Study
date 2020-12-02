package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;

public class boj_S5_2751_Nayeonkiim {
	//내 풀이
	//절댓값!!이  1,000,000보다 작거나 같은 정수
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[2000001];
		for(int i=0; i < N; i++) {
			list[Integer.parseInt(br.readLine())+1000000]+=1; 
		}
		
		int count = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i < list.length; i++) {
			if(list[i] > 0) {
				bw.write(i-1000000 + "\n");
                count++;
			}
            if(count == N)
                break;
		}
		bw.flush();
	}
	
	//public static void main(String[] args) throws Exception, IOException {
	public static void anthorSolution() throws Exception, IOException  {
	      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	      int n = Integer.parseInt(bf.readLine());
	      int[] a = new int[n];
	      for(int i=0; i <n; i++) {
	         a[i] = Integer.parseInt(bf.readLine());
	      }
	      //Arrays.sort() 의 경우 순서를 섞어줘야 시간초과가 안남.
	      shuffle(a);
	      
	      Arrays.sort(a);
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	      for (int i=0; i<n; i++) {
	            bw.write(a[i]+"\n");
	        }
	        bw.flush();
	   }
	   
	   //O(N)
	   private static void shuffle(int[] a) {
	      Random random = new Random();
	      for(int i=a.length-1; i>0; i--) {
	         //0~i+1 int형 난수 반환
	         int index = random.nextInt(i+1);
	         int temp = a[index];
	         a[index] = a[i];
	         a[i] = temp;
	      }
	   }
}
