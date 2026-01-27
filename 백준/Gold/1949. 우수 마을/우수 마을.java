import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static int N;
    private static int[] peopleCount;
    private static int[][] dpTable;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        peopleCount = new int[N + 1];
        graph = new ArrayList[N + 1];
        dpTable = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            peopleCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ATown = Integer.parseInt(st.nextToken());
            int BTown = Integer.parseInt(st.nextToken());
            graph[ATown].add(BTown);
            graph[BTown].add(ATown);
        }

        DFS(1);

        System.out.println(Math.max(dpTable[1][0], dpTable[1][1]));
    }

    private static void DFS(int start) {
        visited[start] = true;
        dpTable[start][0] = 0;
        dpTable[start][1] = peopleCount[start];

        for (Integer i : graph[start]) {
            if (!visited[i]) {
                DFS(i);

                dpTable[start][0] += Math.max(dpTable[i][0], dpTable[i][1]);
                dpTable[start][1] += dpTable[i][0];
            }
        }
    }
}
