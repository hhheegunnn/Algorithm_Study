import java.util.*;

public class boj_S1_20055_Yearang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> ai = new LinkedList<>();
        int[] tmp = new int[n*2];
        for(int i = 0; i < n*2; i++) {
            tmp[i] = sc.nextInt();
        }

        // 로봇 위치
        List<Robot> robots = new ArrayList<>();
        for(int i = 0 ; i < n*2; i++){
            ai.add(tmp[i]);
        }
        Boolean[] robotsLoc = new Boolean[n*2];
        for(int i = 0; i < n*2; i++) {
            robotsLoc[i] = false;
        }
        int answer = 0;
        int empty = 0;

        while(true) {
            // 1. 벨트가 한칸 회전
            answer++;
            ai.addFirst(ai.pollLast());

            for(int i = n*2-1; i >= 1; i--) {
                robotsLoc[i] = robotsLoc[i-1];
            }
            robotsLoc[0] = false;
            int rm = -1;
            for(int i = 0; i < robots.size(); i++) {
                Robot r = robots.get(i);
                r.setLoc(r.getLoc()+1);
                if(r.getLoc() == n-1) {
                    // 로봇 내리기
                    robotsLoc[r.getLoc()] = false;
                    rm = i;
                }
            }
            if(rm !=-1) {
                robots.remove(rm);
            }

            Object[] tmpBelt = ai.toArray();
            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            int rmIdx = -1;
            for (int i = 0; i < robots.size(); i++) {
//                System.out.println((int) tmpBelt[robots.get(i).getLoc() + 1]);

                if ((int) tmpBelt[robots.get(i).getLoc() + 1] >= 1 && !robotsLoc[robots.get(i).getLoc()+1]) {
                    // 로봇 이동
                    robotsLoc[robots.get(i).getLoc()] = false;
                    robotsLoc[robots.get(i).getLoc() + 1] = true;
                    // 내구도
                    tmpBelt[robots.get(i).getLoc()+1] = (int) tmpBelt[robots.get(i).getLoc()+1] - 1;

                    if ((int) tmpBelt[robots.get(i).getLoc()+1] == 0) {
                        empty++;
                    }

                    // 로봇 위치
                    robots.get(i).setLoc(robots.get(i).getLoc() + 1);
                    if (robots.get(i).getLoc() == n - 1) {    // 내리는 장소면
                        // 로봇 내리기
                        robotsLoc[robots.get(i).getLoc()] = false;
                        rmIdx = i;
                    }
                }
            }
            if(rmIdx != -1) {
                robots.remove(rmIdx);
            }
            // 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
            if (!robotsLoc[0] && (int) tmpBelt[0] >= 1) {
                robots.add(new Robot(0,0));
                robotsLoc[0] = true;
                tmpBelt[0] = (int) tmpBelt[0] - 1;
                if ((int) tmpBelt[0] == 0) {
                    empty++;
                }
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
//            System.out.println(Arrays.toString(tmpBelt));
//            System.out.println(Arrays.toString(robotsLoc));
            if (empty >= k) {
                System.out.println(answer);
                return;
            }
            ai = new LinkedList<>();
            for (Object t : tmpBelt) {
                ai.add((int) t);
            }
        }
    }
}
class Robot{
    private int order;

    public Robot(int order, int loc) {
        this.order = order;
        this.loc = loc;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    private int loc;
}