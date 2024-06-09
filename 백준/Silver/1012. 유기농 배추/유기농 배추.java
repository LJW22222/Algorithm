import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;

    static int[][] dataList;

    static int result;

    static int A;
    static int B;


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            result = 0;
            st = new StringTokenizer(in.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            visited = new boolean[A][B];
            dataList = new int[A][B];
            for (int j = 0; j < C; j++) {
                st = new StringTokenizer(in.readLine());
                dataList[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int ib = 0; ib < A; ib++) {
                for (int jb = 0; jb < B; jb++) {
                    if(!visited[ib][jb] && dataList[ib][jb] == 1) {
                        DFS(ib, jb);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    static void DFS(int a, int b) {
        if (a < 0 || a > A -1 || b < 0 || b > B -1) {
            return;
        }
        if (visited[a][b]) {
            return;
        }
        if (dataList[a][b] == 0) {
            return;
        }
        visited[a][b] = true;


        DFS(a + 1, b);
        DFS(a - 1, b);
        DFS(a, b + 1);
        DFS(a, b- 1);
    }
}
