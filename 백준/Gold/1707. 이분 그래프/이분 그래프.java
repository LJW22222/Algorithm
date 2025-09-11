import java.io.*;
import java.util.*;

public class Main {

    //-1 빨강, 0 미색, 1 파랑
    private static int[] visited;

    private static ArrayList<Integer>[] vertex;

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        for (int i = 0; i < a; i++) {
            boolean status = true;
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            vertex = new ArrayList[A + 1];
            for (int cc = 0; cc < A + 1; cc++) {
                vertex[cc] = new ArrayList<>();
            }

            visited = new int[A + 1];
            for (int b = 0; b < B; b++) {
                st = new StringTokenizer(br.readLine(), " ");
                int T = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                vertex[T].add(C);
                vertex[C].add(T);
            }
            for (int dd = 1; dd <= A; dd++) {
                if (visited[dd] == 0) {
                    if (!BFS(dd)) {
                        status = false;
                        break;
                    }
                }
            }

            if (status) {
                bw.append("YES").append("\n");
            } else {
                bw.append("NO").append("\n");
            }

        }
        bw.flush();
    }

    private static boolean BFS(int a) throws IOException {
        Queue<Integer> dataList = new LinkedList<>();
        dataList.add(a);
        visited[a] = -1;
        while (!dataList.isEmpty()) {
            Integer poll = dataList.poll();
            int i1 = visited[poll];
            ArrayList<Integer> vertex1 = vertex[poll];
            for (Integer i : vertex1) {
                if (checkColor(i, i1, dataList)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkColor(int i, int otherColor, Queue<Integer> dataList) {
        if (visited[i] != 0) {
            return visited[i] == otherColor;
        } else if (visited[i] == 0) {
            if (otherColor == 1) {
                visited[i] = -1;
            } else if (otherColor == -1) {
                visited[i] = 1;
            }
            dataList.add(i);
        }
        return false;
    }
}
