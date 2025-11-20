import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 60_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //City Count
        int N = Integer.parseInt(st.nextToken());
        //Bus Count
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N + 1];
        List<Integer>[] dataList = new List[M];
        for (int i = -0; i < M; i++) {
            dataList[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int busRouteA = Integer.parseInt(st.nextToken());
            int busRouteB = Integer.parseInt(st.nextToken());
            int busRouteC = Integer.parseInt(st.nextToken());

            dataList[i] = List.of(busRouteA, busRouteB, busRouteC);
        }

        dist[0] = 0;
        dist[1] = 0;
        for (int a = 0; a < N - 1; a++) {
            for (List<Integer> integers : dataList) {
                Integer A = integers.get(0);
                Integer B = integers.get(1);
                Integer C = integers.get(2);
                if (dist[A] != INF && dist[B] > dist[A] + C) {
                    dist[B] = Math.min(dist[B], dist[A] + C);
                }
            }
        }


        boolean status = false;
        for (List<Integer> integers : dataList) {
            Integer A = integers.get(0);
            Integer B = integers.get(1);
            Integer C = integers.get(2);
            if (!status && A == 1) {
                status = true;
            }

            if (dist[B] != INF && dist[B] > dist[A] + C) {
                bw.append("-1").append("\n");
                bw.flush();
                return;
            }
        }


        for (int i = 2; i < N + 1; i++) {
            if (dist[i] == INF || dist[1] == INF || !status) {
                bw.append("-1").append("\n");
            } else {
                bw.append(String.valueOf(dist[i])).append("\n");
            }
        }

        bw.flush();
    }
}
