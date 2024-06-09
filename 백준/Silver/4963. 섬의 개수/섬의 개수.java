import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;

    static int[][] dataList;

    static boolean[][] visitedList;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int result = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }
            dataList = new int[B][A];
            visitedList = new boolean[B][A];
            for (int i = 0; i < B; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < A; j++) {
                    dataList[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < B; i++) {
                for (int j = 0; j < A; j++) {
                    if(!visitedList[i][j] && dataList[i][j] == 1) {
                        DFS(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        };

    }

    static void DFS(int a, int b) {
        if (a > B - 1 || b > A - 1 || a < 0 || b < 0) {
            return;
        }
        if (visitedList[a][b]) {
            return;
        }
        if (dataList[a][b] == 0) {
            return;
        }
        visitedList[a][b] = true;

        DFS(a - 1, b);
        DFS(a + 1, b);
        DFS(a, b -1);
        DFS(a, b + 1);
        DFS(a+1, b + 1);
        DFS(a+1, b - 1);
        DFS(a-1, b + 1);
        DFS(a-1, b - 1);
    }
}
