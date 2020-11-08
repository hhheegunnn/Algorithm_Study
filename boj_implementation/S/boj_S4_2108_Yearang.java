import java.util.*;

public class boj_S4_2108_Yearang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numList = new int[n];
        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }
        Arrays.sort(numList);
        System.out.println(getAverage(numList));
        System.out.println(getMedian(numList));
        System.out.println(getMode(numList));
        System.out.println(getRange(numList));

    }

    public static int getAverage(int[] numList) {
        double sum = 0;
        for (int t : numList) {
            sum += t;
        }
        return (int) Math.round(sum / numList.length);
    }

    public static int getMedian(int[] numList) {
        return numList[numList.length / 2];
    }

    public static int getMode(int[] numList) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int t : numList) {
            if (m.containsKey(t)) {
                m.put(t, m.get(t) + 1);
            } else {
                m.put(t, 1);
            }
        }
        List<Integer> key = new ArrayList<>(m.keySet());
        Collections.sort(key, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (m.get(o1).compareTo(m.get(o2)) == 0) {
                    return o1.compareTo(o2);
                } else {
                    return -m.get(o1).compareTo(m.get(o2));
                }
            }
        });

        return key.size() >= 2 ? (m.get(key.get(0)) == m.get(key.get(1)) ? key.get(1) : key.get(0)) : key.get(0);
    }

    public static int getRange(int[] numList) {
        return numList[numList.length - 1] - numList[0];
    }
}
