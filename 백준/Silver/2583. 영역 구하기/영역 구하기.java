import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dataList;
    static int a;
    static int b;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dataList = new int[a][b];
        visited = new boolean[a][b];
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(bf.readLine());
            drewLine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        List<Integer> stringList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (!visited[i][j]) {
                    int bfs = BFS(i, j, 0);
                    if (bfs != 0) {
                        stringList.add(bfs);
                        count +=1 ;
                    }
                }
            }
        }
        Collections.sort(stringList);
        print(stringList, count);
    }

    private static void print(List<Integer> stringList, int count2) {
        System.out.println(count2);
        StringBuilder sb = new StringBuilder();
        for (Integer i : stringList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    private static int BFS(int a1, int b1, int count) {
        if (a1 < 0 || b1 < 0 || a1 >= a || b1 >= b) {
            return count;
        }
        if (visited[a1][b1]) {
            return count;
        }
        if (dataList[a1][b1] == 1) {
            return count;
        }

        if (dataList[a1][b1] == 0) {
            count += 1;
        }

        visited[a1][b1] = true;

        count = BFS(a1 + 1, b1, count);
        count = BFS(a1 - 1, b1, count);
        count = BFS(a1, b1 + 1, count);
        count = BFS(a1, b1 - 1, count);

        return count;
    }

    private static void drewLine(int a1, int b1, int c1, int d1) {
        for (int i = a-1-b1; i >= a-d1; i--) {
            for (int j = a1; j < c1; j++) {
                dataList[i][j] = 1;
            }
        }
    }
}
