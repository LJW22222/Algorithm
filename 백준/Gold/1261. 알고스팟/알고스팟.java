import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dataList;
    private static int X;
    private static int Y;

    private static int[][] dist;

    private static final int[][] direction = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dataList = new int[Y][X];
        dist = new int[Y][X];

        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }

        dist[0][0] = 0;

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), "");
            char[] charArray = st.nextToken().toCharArray();
            for (int j = 0; j < X; j++) {
                dataList[i][j] = charArray[j] - '0';
            }
        }
        DFS();
        System.out.println(dist[Y - 1][X - 1]);
    }

    private static void DFS() {
        Deque<int[]> dataList = new ArrayDeque<>();
        dataList.addFirst(new int[]{0, 0});
        while (!dataList.isEmpty()) {
            int[] poll = dataList.poll();
            int y = poll[0];
            int x = poll[1];
            if (y == Y - 1 && x == X - 1) {
                return;
            }
            intputQueue(dataList, y, x);
        }
    }

    private static void intputQueue(Deque<int[]> queue, int y, int x) {
        for (int[] ints : direction) {
            int addY = y + ints[0];
            int addX = x + ints[1];

            if (addX >= X || addY >= Y || addX < 0 || addY < 0) {
                continue;
            }

            if (dataList[addY][addX] == 0) {
                if (dist[addY][addX] == -1) {
                    queue.addFirst(new int[]{addY, addX});
                    dist[addY][addX] = dist[y][x];
                    continue;
                }
            }

            if (dataList[addY][addX] == 1) {
                if (dist[addY][addX] == -1) {
                    dist[addY][addX] = dist[y][x] + 1;
                    queue.addLast(new int[]{addY, addX});
                } else {
                    if (dist[addY][addX] >= dist[y][x] + 1) {
                        dist[addY][addX] = dist[y][x] + 1;
                    }
                }
            }
        }
    }
}
