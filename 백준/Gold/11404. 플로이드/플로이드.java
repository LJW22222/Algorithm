import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer st;
    private static int INF = 1_000_000_000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());

        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        for (int i = 1; i < N + 1; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int scorePoint = Integer.parseInt(st.nextToken());

            dist[startCity][endCity] = Math.min(dist[startCity][endCity], scorePoint);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int z = 1; z < N + 1; z++) {
                    dist[j][z] = Math.min(dist[j][z], dist[j][i] + dist[i][z]);
                }

            }
        }

        dist = Arrays.stream(dist)
                .map(row ->
                        Arrays.stream(row)
                                .map(n -> n == INF ? 0 : n)
                                .toArray())
                .toArray(int[][]::new);

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                bw.append(String.valueOf(dist[i][j])).append(" ");
            }
            bw.append("\n");
        }

        bw.flush();

    }
}
