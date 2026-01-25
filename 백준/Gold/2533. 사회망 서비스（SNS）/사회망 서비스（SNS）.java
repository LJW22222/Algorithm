import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static int N;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }
        DFS(1);

        System.out.println(Math.min(dp[1][1], dp[1][0]));
    }

    private static void DFS(int i) {
        visited[i] = true;
        dp[i][0] = 0;
        dp[i][1] = 1;
        for (int o : graph[i]) {
            if(!visited[o]) {
                DFS(o);

                dp[i][0] += dp[o][1];
                dp[i][1] += Math.min(dp[o][0], dp[o][1]);
            }
        }
    }
}
