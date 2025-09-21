import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] sosuList;
    private static boolean[] visited;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        sosuList = new boolean[10_000];


        for (int p = 2; p * p < 10000; p++) {
            if (!sosuList[p]) {
                for (int x = p * p; x < 10000; x += p) sosuList[x] = true;
            }
        }


        int a = Integer.parseInt(st.nextToken());
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[10_000];
            int startNumber = Integer.parseInt(st.nextToken());
            int endNumber = Integer.parseInt(st.nextToken());
            BFS(startNumber, endNumber);
        }
        bw.flush();
    }

    private static void BFS(int startNumber, int endNumber) throws IOException {
        if (startNumber == endNumber) {
            bw.append(String.valueOf(0)).append("\n");
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNumber, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == endNumber) {
                bw.append(String.valueOf(poll[1])).append("\n");
                return;
            }
            findNumber(poll[0], poll[1], queue);

        }
    }

    private static void findNumber(int startNumber, int count, Queue<int[]> queue) {
        for (int i = 0; i < 4; i++) {
            String s = String.valueOf(startNumber);
            String[] split = s.split("");
            String s1 = split[i];
            for (int j = 0; j <= 9; j++) {
                if (Integer.parseInt(s1) == j) {
                    continue;
                }
                if (i == 0 && Integer.parseInt(s1) == 0) {
                    continue;
                }

                split[i] = String.valueOf(j);
                int number = Integer.parseInt(
                        String.join("", split));

                if (1000 <= number && number < 10_000 && !sosuList[number] && !visited[number]) {
                    queue.add(new int[]{number, count + 1});
                    visited[number] = true;
                }
            }
        }
    }
}
