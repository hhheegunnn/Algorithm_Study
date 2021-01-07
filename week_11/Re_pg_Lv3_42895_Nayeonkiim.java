package week11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Re_pg_Lv3_42895_Nayeonkiim {
	//dp로 풀기
	public static int solution(int N, int number) {
	    int answer = -1;
	    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	    HashSet<Integer> s = new HashSet<>();
	    s.add(N);
	    map.put(1, s);

	    loop : for (int i = 2; i < 9; i++) {
	    	//중복이 없도록 set으로
	        HashSet<Integer> set = new LinkedHashSet<>();
	        int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;
	        if (NNN == number){
	            return i;
	        }

	        set.add(NNN);

	        //1-{2}/ 2 - {22,4,1,0} / 3 - {222,-20,20,44,11,0, ...}
	        //1,2 구성 요소끼리 연산해서 값을 3에 넣는 방식
	        for (int j = 1; j <= i / 2; j++) {
	            Iterator<Integer> it1 = map.get(j).iterator();
	            Iterator<Integer> it2 = map.get(i - j).iterator();

	            while (it1.hasNext()) {
	                int itValue1 = it1.next();
	                while (it2.hasNext()) {
	                    int itValue2 = it2.next();
	                    for (Operator o : Operator.values()) {
	                        int calculate = o.calculate(itValue1, itValue2);
	                       
	                        if (calculate == number){
	                            answer = i;
	                            break loop;
	                        }

	                        set.add(calculate);
	                    }
	                }
	            }
	        }
	        map.put(i, set);
	    }

	    return answer;
	}

	enum Operator {
	    PLUS {
	        @Override
	        public int calculate(int i, int j) {
	            return i + j;
	        }
	    }, MINUS {
	        @Override
	        public int calculate(int i, int j) {
	            return i - j;
	        }
	    }, BACKMINUS {
	        @Override
	        public int calculate(int i, int j) {
	            return j - i;
	        }
	    }, MUL {
	        @Override
	        public int calculate(int i, int j) {
	            return i * j;
	        }
	    }, DIV {
	        @Override
	        public int calculate(int i, int j) {
	            if (j == 0){
	                return 0;
	            }
	            return i / j;
	        }
	    }, BACKDIV {
	        @Override
	        public int calculate(int i, int j) {
	            if (i == 0){
	                return 0;
	            }
	            return j / i;
	        }
	    };

	    public abstract int calculate(int i, int j);
	}
	
	public static void main(String[] args) {
		int n = 2;
		int number = 11;
		System.out.println(solution(n, number));
	}
}

//dfs로 풀기
class 방법2 {
	static int answer = -1;
	
	public static int solution(int N, int number) {
		dfs(N, number, 0, 0);
		return answer;
	}
	
	private static void dfs(int N, int number, int cnt, int prev) {
		int temp_N = N;
		if (cnt > 8) {
			answer = -1;
			return;
		}
		
		if(number == prev) {
			if(answer == -1 || answer > cnt) {
				answer = cnt;
			}
			return;
		}
		
		for(int i=0; i < 8-cnt; i++) {
			dfs(N, number, cnt+i+1, prev-temp_N);
			dfs(N, number, cnt+i+1, prev+temp_N);
			dfs(N, number, cnt+i+1, prev*temp_N);
			dfs(N, number, cnt+i+1, prev/temp_N);
			
			temp_N = increaseNumber(temp_N, N);
		}
	}

	private static int increaseNumber(int value, int N) {
		return value * 10 + N;
	}
}
