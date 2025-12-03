import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int[][] dataList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dataList = new int[N][4];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dataList[i][0] = Integer.parseInt(st.nextToken());
            dataList[i][1] = Integer.parseInt(st.nextToken());
            dataList[i][2] = Integer.parseInt(st.nextToken());
            dataList[i][3] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BFS(i);
                count+= 1;
            }
        }

        boolean original = false;
        for (int i = 0; i < N; i++) {
            int x1 = dataList[i][0];
            int y1 = dataList[i][1];
            int x2 = dataList[i][2];
            int y2 = dataList[i][3];

            if ((x1 == 0 || x2 == 0) && y1 <= 0 && 0 <= y2) {
                original = true;
            }

            if ((y1 == 0 || y2 == 0) && x1 <= 0 && 0 <= x2) {
                original = true;
            }
        }

        System.out.println(original ? count - 1 : count);

    }

    //dataList -> 0 | x1, 1 | y1, 2 | x2, 3 | y2
    private static void BFS(int index) {
        Queue<Integer> queueList = new ArrayDeque<>();
        queueList.add(index);
        while (!queueList.isEmpty()) {
            int getIndex = queueList.poll();
            for (int j = 0; j < N; j++) {
                if (!visited[j] && checkBox(getIndex, j)) {
                    visited[j] = true;
                    queueList.add(j);
                }

            }

        }
    }

    private static boolean checkBox(int index, int nextIndex) {
        int x1 = dataList[index][0];
        int y1 = dataList[index][1];
        int x2 = dataList[index][2];
        int y2 = dataList[index][3];

        int nx1 = dataList[nextIndex][0];
        int ny1 = dataList[nextIndex][1];
        int nx2 = dataList[nextIndex][2];
        int ny2 = dataList[nextIndex][3];

        if (x2 < nx1 || x1 > nx2 || y2 < ny1 || y1 > ny2) {
            return false;
        }

        if (x1 < nx1 && y1 < ny1 && x2 > nx2 && y2 > ny2) {
            return false;
        }
        if (nx1 < x1 && ny1 < y1 && nx2 > x2 && ny2 > y2) {
            return false;
        }

        return true;
    }
}