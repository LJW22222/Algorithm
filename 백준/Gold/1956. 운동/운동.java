import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        Queue<int[]> nodeList = new ArrayDeque<>();

        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        for (int i = 0; i < N + 1; i++) {
            dist[i][i] = 0;
        }

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int km = Integer.parseInt(st.nextToken());
            dist[startPoint][endPoint] = km;
            nodeList.add(new int[]{startPoint, endPoint});
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int z = 1; z < N + 1; z++) {
                    dist[j][z] = Math.min(dist[j][z], dist[j][i] + dist[i][z]);
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }
            }
        }

        int result = INF;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(dist[i][j] == 0 | dist[j][i] == 0) {
                    continue;
                }
                result = Math.min(result, dist[i][j] + dist[j][i]);
            }
        }
        if (result == INF) {
            System.out.println("-1");
            return;
        }
        System.out.println(result);
    }
}
