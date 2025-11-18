import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String N;
    private static int K;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[K + 1][1_000_001];

        BFS(Integer.parseInt(N));

    }

    private static void BFS(int startNumber) {
        Queue<int[]> queueList = new ArrayDeque<>();
        queueList.add(new int[]{startNumber, 0});
        visited[0][startNumber] = true;

        int resultNumber = -1;
        while (!queueList.isEmpty()) {
            int[] poll = queueList.poll();
            int getNumber = poll[0];
            int getDepth = poll[1];
            if (getDepth == K) {
                if (resultNumber == -1) {
                    resultNumber = getNumber;
                } else {
                    resultNumber = Math.max(resultNumber, getNumber);
                }
            }

            swap(queueList, getNumber, getDepth);
        }

        System.out.println(resultNumber);
    }

    private static void swap(Queue<int[]> queueList, int getNumber, int getDepth) {
        if (getDepth == K) {
            return;
        }

        String s = String.valueOf(getNumber);
        char[] number = s.toCharArray();
        int plusDepth = getDepth + 1;


        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                char[] copyNumber = s.toCharArray();
                char temp = number[j];
                copyNumber[j] = number[i];
                copyNumber[i] = temp;
                int resultNumber = Integer.parseInt(String.valueOf(copyNumber));
                if (copyNumber[0] == '0' || visited[plusDepth][resultNumber]) {
                    continue;
                }

                visited[plusDepth][resultNumber] = true;
                queueList.add(new int[]{resultNumber, plusDepth});
            }
        }
    }
}
