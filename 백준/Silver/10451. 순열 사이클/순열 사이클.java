import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dataList;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());

        for (int i = 0; i < A; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            dataList = new int[i1+1];
            visited = new boolean[i1+1];

            st = new StringTokenizer(br.readLine(), " ");

            for (int jj = 1; jj <= i1; jj++) {
                dataList[jj] = Integer.parseInt(st.nextToken());
            }

            for (int qq = 1; qq <= i1; qq++) {
                if (!visited[qq]) {
                    sum += BFS(qq);
                }
            }
            bw.append(String.valueOf(sum)).append("\n");
        }

        bw.flush();

    }

    private static int BFS(int a) {
        Queue<Integer> queueList = new LinkedList<>();
        queueList.add(a);
        int ad = a;
        while (!queueList.isEmpty()) {
            Integer poll = queueList.poll();
            int i = dataList[poll];
            visited[i] = true;
            if (ad == i) {
                return 1;
            }
            queueList.add(i);
        }
        return 0;
    }
}
