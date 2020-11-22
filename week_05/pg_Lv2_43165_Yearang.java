public class pg_Lv2_43165_Yearang {
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 1};

        System.out.println(solution(test, 3));
    }

    public static int solution(int[] numbers, int target) {
        numbersStatic = numbers;

        dfs(numbers[0], 0,0,target);
        dfs(-numbers[0], 0,0,target);
        return answer;
    }

    static int [] numbersStatic;
    static int answer = 0;
    public static void dfs(int num, int n, int sum, int target) {
        sum += num;

        if(numbersStatic.length == n +1) {
            if(sum == target) {
                answer++;
                return;
            }
            return;
        }
        n++;
        dfs(numbersStatic[n], n, sum, target);
        dfs(-numbersStatic[n], n, sum, target);

    }
}
