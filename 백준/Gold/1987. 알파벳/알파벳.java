import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visited;

    static String[][] dataList;

    static Set<String> EnligshList;
    static int A;
    static int B;
    static int MaxCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        EnligshList = new HashSet<>();
        visited = new boolean[A][B];
        dataList = new String[A][B];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            String[] split = st.nextToken().split("");
            EnligshList.addAll(List.of(split));
            System.arraycopy(split, 0, dataList[i], 0, B);
        }

        DFS(0, 0, 0);
        System.out.println(MaxCount);

    }

    static void DFS(int a, int b, int count) {
        if (a >= A || a < 0 || b < 0 || b >= B) {
            return;
        }
        if (visited[a][b] || !EnligshList.contains(dataList[a][b])) {
            return;
        }

        visited[a][b] = true;
        EnligshList.remove(dataList[a][b]);
        count++;
        MaxCount = Math.max(MaxCount,count);
        DFS(a + 1, b, count);
        DFS(a - 1, b, count);
        DFS(a, b+1, count);
        DFS(a, b-1, count);
        EnligshList.add(dataList[a][b]);
        visited[a][b] = false;

    }
}
