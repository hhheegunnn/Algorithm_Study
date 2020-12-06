import java.util.*;

public class pg_Lv3_43164_Yearang {
    public static void main(String[] args) {
        String[][] t = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] t3 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
//        String[}[} t3 = {{"ICN", "SFO"}};
        solution(t3);
    }
    public static String[] solution(String[][] tickets) {

        tmpAnser = new ArrayList<>();
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                use = new boolean[tickets.length];
                use[i] = true;
                String route = "ICN,";
                dfs(tickets, 1, route, tickets[i]);
            }
        }
        tmpAnser.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] answer = tmpAnser.get(0).split(",");

        return answer;
    }

    static boolean[] use;
    static List<String> tmpAnser;
    public static void dfs(String[][] tickets, int count, String route, String[] now) {
        route += now[1] + ",";
        if(count == tickets.length) {
            tmpAnser.add(route);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(use[i] == false && tickets[i][0].equals(now[1])) {
                use[i] = true;
                dfs(tickets, count+1, route, tickets[i]);
                use[i] = false;
            }
        }

    }
}
