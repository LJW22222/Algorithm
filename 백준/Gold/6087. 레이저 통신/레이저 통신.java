import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] dataList;
    private static int[][][] countMap;
    private static int X;
    private static int Y;
    private static List<int[]> location = new ArrayList<>();

    private static final int[][] directionList = {
            //0 -> x, 1 -> y
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dataList = new char[Y][X];
        countMap = new int[Y][X][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < Y; j++) {
                for (int q = 0; q < X; q++) {
                    countMap[j][q][i] = -1;
                }
            }
        }


        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(bf.readLine());
            char[] charDataList = st.nextToken().toCharArray();
            for (int j = 0; j < X; j++) {
                char c = charDataList[j];
                dataList[i][j] = c;
                if (c == 'C') {
                    location.add(new int[]{j, i});
                }
            }
        }

        BFS(location.get(0)[0], location.get(0)[1]);

    }

    private static void BFS(int x, int y) {
        PriorityQueue<int[]> queueList = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[3])
                        .thenComparingInt(a -> a[1])
                        .thenComparingInt(a -> a[0])
                        .thenComparingInt(a -> a[2])
        );
        queueList.add(new int[]{x, y, 0, 0});
        queueList.add(new int[]{x, y, 1, 0});
        queueList.add(new int[]{x, y, 2, 0});
        queueList.add(new int[]{x, y, 3, 0});
        countMap[y][x][0] = 0;
        countMap[y][x][1] = 0;
        countMap[y][x][2] = 0;
        countMap[y][x][3] = 0;
        while (!queueList.isEmpty()) {
            int[] poll = queueList.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int direction = poll[2];
            int mirrorCount = poll[3];
            if (countMap[y1][x1][direction] != mirrorCount) {
                continue;
            }
            if (location.get(1)[0] == x1 && location.get(1)[1] == y1) {
                System.out.println(mirrorCount);
                break;
            }

            makeMirror(x1, y1, mirrorCount, queueList, direction);
            goStraight(x1, y1, mirrorCount, queueList, direction);
        }
    }

    private static void makeMirror(int x, int y, int mirrorCount, PriorityQueue<int[]> queueList, int direction) {
        int addMirrorCount = mirrorCount + 1;
                if (direction == 0 || direction == 1) {
                    int[] ints = directionList[2];
                    int[] ints1 = directionList[3];
                    insertCheckMap(x + ints[0], y + ints[1], addMirrorCount, queueList, 2);
                    insertCheckMap(x + ints1[0], y + ints1[1], addMirrorCount, queueList, 3);

                } else {
                    int[] ints = directionList[0];
                    int[] ints1 = directionList[1];
                    insertCheckMap(x + ints[0], y + ints[1], addMirrorCount, queueList, 0);
                    insertCheckMap(x + ints1[0], y + ints1[1], addMirrorCount, queueList, 1);
                }
    }

    private static void insertCheckMap(int addX, int addY, int addMirrorCount, PriorityQueue<int[]> queueList, int direction) {
        if ((addX >= X || addY >= Y || addX < 0 || addY < 0) || dataList[addY][addX] == '*') {
            return;
        }

        if (countMap[addY][addX][direction] == -1 || countMap[addY][addX][direction] > addMirrorCount) {
            queueList.add(new int[]{addX, addY, direction, addMirrorCount});
            countMap[addY][addX][direction] = addMirrorCount;
        }

    }


    private static void goStraight(int x, int y, int mirrorCount, PriorityQueue<int[]> queueList, int direction) {
        int[] ints = directionList[direction];

        int addX = x + ints[0];
        int addY = y + ints[1];


        insertCheckMap(addX, addY, mirrorCount, queueList, direction);

    }
}
