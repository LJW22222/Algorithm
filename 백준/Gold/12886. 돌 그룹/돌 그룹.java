
import java.io.IOException;
import java.util.*;


public class Main {

    private static int sum;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        sum = A + B + C;
        int[] dataList = new int[3];
        visited = new boolean[sum + 1][sum + 1];

        dataList[0] = A;
        dataList[1] = B;
        dataList[2] = C;

        if ((A + B + C) % 3 != 0) {
            System.out.println(0);
            return;
        }

        int bfs = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                bfs = BFS(dataList[i], dataList[j]);
                if (bfs == 1) {
                    System.out.println(bfs);
                    return;
                }
            }
        }
        System.out.println(bfs);
    }

    private static int BFS(int a, int b) {
        Queue<int[]> dataList = new LinkedList<>();
        dataList.add(new int[]{a, b});
        while (!dataList.isEmpty()) {
            int[] poll = dataList.poll();
            int getX = poll[0];
            int getY = poll[1];

            if (getX == sum / 3 && getY == sum / 3) {
                return 1;
            }

            getMixture(getX, getY, dataList);

        }
        return 0;
    }

    private static void getMixture(int x, int y, Queue<int[]> dataList) {
        int minX = Math.min(x, y);
        int maxY = Math.max(x, y);

        int resultX = minX + minX;
        int resultY = maxY - minX;


        int[] ints = {resultX, resultY, sum - resultX - resultY};
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int getX = ints[i];
                int getY = ints[j];

                if (getX < 0 || getY < 0 || getX > sum || getY > sum) {
                    continue;
                }

                if (visited[getX][getY]) {
                    continue;
                }

                visited[getX][getY] = true;

                dataList.add(new int[]{getX, getY});
            }
        }


    }
}
