import java.io.*;
import java.util.*;
import java.util.stream.Stream;
//urL
public class Main {
    private static int A;
    private static int B;

    private static char[][] dataList;
    private static boolean[][] visited;
    private static int[][] distList;
    private static int[][] dp;


    private static final int[][] directionList = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            ArrayList<int[]> nodeList = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }
            dataList = new char[B][A];

            int dirtyNodeCount = 1;
            for (int i = 0; i < B; i++) {
                st = new StringTokenizer(bf.readLine());
                char[] charArray = st.nextToken().toCharArray();
                for (int j = 0; j < A; j++) {
                    dataList[i][j] = charArray[j];
                    if (charArray[j] == 'o') {
                        nodeList.add(0, new int[]{i, j});
                    }
                    if (charArray[j] == '*') {
                        dirtyNodeCount += 1;
                        nodeList.add(new int[]{i, j});
                    }

                }
            }

            distList = new int[dirtyNodeCount][dirtyNodeCount];

            for (int[] value : distList) {
                Arrays.fill(value, -1);
            }

            for (int i = 0; i < dirtyNodeCount; i++) {
                int[] ints = nodeList.get(i);
                BFS(ints[0], ints[1], i, dirtyNodeCount, nodeList);
            }

            boolean b = Arrays.stream(distList).
                    flatMapToInt(Arrays::stream)
                    .anyMatch(x -> x == -1);

            if (b) {
                bw.append("-1").append("\n");
                continue;
            }

            dp = new int[dirtyNodeCount][1 << dirtyNodeCount];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }

            int tsp = TSP(0, 1, dirtyNodeCount);

            bw.append(String.valueOf(tsp)).append("\n");
        }
        bw.flush();
    }

    private static int TSP(int startNode, int visited, int N) {
        int t = 0;
        if (visited == (1 << N) - 1) {
            return 0;
        }

        if (dp[startNode][visited] != -1) {
            return dp[startNode][visited];
        }

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) != 0) {
                continue;
            }

            if (distList[startNode][next] == -1) {
                continue;
            }

            int nextVisited = visited | (1 << next);

            int cost = distList[startNode][next] + TSP(next, nextVisited, N);
            if (t == 0) {
                t = cost;
            } else {
                t = Math.min(t, cost);
            }
        }

        dp[startNode][visited] = t;
        return t;
    }

    private static void BFS(int y, int x, int number, int nodeListSize, ArrayList<int[]> nodeList) {
        Queue<int[]> queueList = new ArrayDeque<>();
        visited = new boolean[B][A];
        queueList.add(new int[]{y, x, 0});
        visited[y][x] = true;
        while (!queueList.isEmpty()) {
            int[] poll = queueList.poll();
            int getY = poll[0];
            int getX = poll[1];
            int moveCount = poll[2];

            for (int aa = 0; aa < nodeListSize; aa++) {
                int[] ints = nodeList.get(aa);
                if (getY == ints[0] && getX == ints[1]) {
                    if (distList[number][aa] == -1) {
                        distList[number][aa] = moveCount;
                    }
                }
            }
            direction(getY, getX, moveCount, queueList);
        }
    }

    private static void direction(int y, int x, int moveCount, Queue<int[]> queue) {
        for (int[] ints : directionList) {
            int addY = y + ints[0];
            int addX = x + ints[1];

            if (addY >= B || addY < 0 || addX >= A || addX < 0) {
                continue;
            }


            if (visited[addY][addX]) {
                continue;
            }

            if (dataList[addY][addX] == 'x') {
                continue;
            }

            visited[addY][addX] = true;

            int nextCount = moveCount + 1;
            queue.add(new int[]{addY, addX, nextCount});
        }

    }


}
