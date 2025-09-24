import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] visited;
    private static int[] cap;
    private static final int[][] status = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 2},
            {2, 0}, {2, 1}
    };

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        cap = new int[]{A, B, C};
        int[] data = new int[3];
        visited = new boolean[A + 1][B + 1];
        data[2] = C;

        BFS(data);
        bw.flush();
    }

    private static void BFS(int[] data) throws IOException {
        Queue<int[]> queueList = new ArrayDeque<>();
        Set<Integer> resultList = new TreeSet<>();

        queueList.add(data);
        while (!queueList.isEmpty()) {
            int[] poll = queueList.poll();
            visited[poll[0]][poll[1]] = true;
            for (int[] ints : status) {
                checkWater(ints[0], ints[1], poll, queueList, resultList);
            }
        }

        for (Integer i : resultList) {
            bw.append(String.valueOf(i)).append(" ");
        }
    }

    private static void checkWater(int to, int from, int[] data, Queue<int[]> queueList, Set<Integer> resultList) {
        int min = Math.min(data[from], cap[to] - data[to]);
        if(min == 0) return;

        int[] ints = Arrays.copyOf(data, 3);

        ints[to] += min;
        ints[from] -= min;


        if (ints[0] == 0) {
            resultList.add(ints[2]);
        }

        if (!visited[ints[0]][ints[1]]) {
            queueList.add(ints);
        }

    }



}
