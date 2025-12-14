import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static int[][] dataList;
    private static boolean[] visited;
    private static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        dataList = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1) {
                    dataList[i][j] = number;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] go = new int[st.countTokens()];
        int i2 = 0;
        boolean status = false;
        for (int i = 0; i < go.length; i++) {

            int i1 = Integer.parseInt(st.nextToken());
            if (i >= 1 && i1 != i2) {
                status = true;
            }
            i2 = i1;
            go[i] = i1;
        }

        if (!status) {
            System.out.println("YES");
            return;
        }

        BFS(go[0]);

        for (int i = 0; i < go.length; i++) {
            if (!visited[go[i]]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void BFS(int i) {
        Queue<Integer> queueList = new LinkedList<>();
        queueList.add(i);
        while (!queueList.isEmpty()) {
            int getI = queueList.poll();
            checking(getI, queueList);
        }
    }

    private static void checking(int i, Queue<Integer> queueList) {
        for (int jj = 1; jj < N + 1; jj++) {

            //출발 -> 도착 | 도착 시티를 이미 방문 했음.
            if (visited[jj]) {
                continue;
            }

            if (dataList[i][jj] != 1) {
                continue;
            }

            visited[jj] = true;
            queueList.add(jj);
        }

    }
}
