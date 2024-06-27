import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int A;
    static int B;

    static int[][] dataList;

    static int dataListCount;

    static int dataCount;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dataList = new int[A][B];
        visited = new boolean[A][B];
        ArrayList<Integer> resultDataCountList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < B; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    if (dataCount != 0) {
                        dataListCount++;
                        resultDataCountList.add(dataCount);
                    }
                    dataCount = 0;
                }
            }
        }
        System.out.println(dataListCount);
        Optional<Integer> max = resultDataCountList.stream().max(Comparator.naturalOrder());
        if (max.isPresent()) {
            System.out.println(max.get());
        } else {
            System.out.println(0);
        }

    }

    static void DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= A || y >= B) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        if (dataList[x][y] == 1) {
            dataCount++;
            DFS(x + 1, y);
            DFS(x - 1, y);
            DFS(x, y+1);
            DFS(x, y-1);
        }


    }

}
