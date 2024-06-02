import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] A;

    static boolean[][] visited;

    static int[] countList;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int i1 = Integer.parseInt(st.nextToken())+2;
        visited = new boolean[i1][i1];
        A = new String[i1][i1];
        countList = new int[3];
        for (int i = 1; i < A.length-1; i++) {
            st = new StringTokenizer(in.readLine());
            String[] split = st.nextToken().split("");
            if (A.length - 1 - 1 >= 0) System.arraycopy(split, 0, A[i], 1, A.length - 1 - 1);
        }
        for (int i = 1; i < A.length-1; i++) {
            for (int j = 1; j < A.length-1; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, A[i][j]);
                    count++;
                }
            }
        }
        System.out.print(count + " ");
        for (int i = 1; i < A.length - 1; i++) {
            for (int j = 1; j < A.length - 1; j++) {
                if (A[i][j].equals("G")) {
                    A[i][j] = "R";
                }
            }
        }
        count = 0;
        visited = new boolean[i1][i1];
        for (int i = 1; i < A.length-1; i++) {
            for (int j = 1; j < A.length-1; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, A[i][j]);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    static void DFS(int a, int b, String color) {
        if (a <= 0 || a >= A.length - 1 || b <= 0 || b >= A.length - 1) {
            return;
        }
        if (visited[a][b]) {
            return;
        }

        visited[a][b] = true;

        if (color.equals(A[a +1][b])) {
            DFS(a + 1, b, color);
        }
        if (color.equals(A[a -1][b])) {
            DFS(a - 1, b, color);
        }
        if (color.equals(A[a][b +1])) {
            DFS(a, b + 1, color);
        }
        if (color.equals(A[a][b -1])) {
            DFS(a, b - 1, color);
        }
    }
}
