import java.io.IOException;
import java.util.*;

public class Main {

    private static int K;
    private static int[] mapList;
    private static boolean[] visited = new boolean[100_000_001];
    private static ArrayList<Integer> resultList = new ArrayList<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        mapList = new int[100_000_001];
        BFS(N);
        System.out.println(sb.toString());
    }

    public static void BFS(int N) {
        Queue<int[]> queueList = new LinkedList<>();
        queueList.add(new int[]{N, 0});
        while (!queueList.isEmpty()) {
            int[] poll = queueList.poll();
            int getN = poll[0];
            int getCount = poll[1];
            if (getN == K) {
                sb.append(getCount).append("\n");
                printMap(N);
                Collections.reverse(resultList);
                for (Integer i : resultList) {
                    sb.append(i).append(" ");
                }
                return;
            }
            int plusCount = getCount + 1;
            inputQueue(queueList, getN, plusCount);


        }
    }

    public static void printMap(int N) {
        int c = K;
        while (true) {
            resultList.add(c);
            if (c == N) {
                return;
            }
            c = mapList[c];
        }
    }

    public static void inputQueue(Queue<int[]> queueList, int getN, int plusCount) {

        if (getN < K && !visited[getN * 2]) {
            visited[getN * 2] = true;
            mapList[getN * 2] = getN;
            queueList.add(new int[]{getN * 2, plusCount});
        }
        if (getN < K && !visited[getN + 1]) {
            visited[getN + 1] = true;
            mapList[getN + 1] = getN;
            queueList.add(new int[]{getN + 1, plusCount});
        }

        if (getN - 1 >= 0 && !visited[getN - 1]) {
            visited[getN - 1] = true;
            mapList[getN - 1] = getN;
            queueList.add(new int[]{getN - 1, plusCount});

        }

    }
}
