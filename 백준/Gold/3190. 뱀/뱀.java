import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int snakeLocationIndex = 0;

    private static List<String>[] snakeLocation;
    private static int[][] dataList;

    private static boolean[][] visitedSnake;

    private static int snakeX;
    private static int snakeY;
    private static int snakeDirection;
    private static int N;

    private static final int[][] direction = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        snakeX = 0;
        snakeY = 0;
        snakeDirection = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기 데이터
        N = Integer.parseInt(st.nextToken());
        dataList = new int[N][N];
        visitedSnake = new boolean[N][N];
        dataList[0][0] = 1;

        initAppleLocationData(br);
        initSnakeLocationData(br);

        startGame();
    }

    private static void startGame() {
        int time = 0;

        Deque<int[]> snak = new ArrayDeque<>();
        snak.addLast(new int[]{0, 0});

        visitedSnake[0][0] = true;

        while (true) {
            int[] snakHead = snak.getLast();

            int plusSnakeX = snakHead[0] + direction[snakeDirection][0];
            int plusSnakeY = snakHead[1] + direction[snakeDirection][1];


            if (checkSnakeLocation(time)) {
                snakeLocationIndex += 1;
                continue;
            }

            if (plusSnakeX < 0 || plusSnakeY < 0 || plusSnakeX >= N || plusSnakeY >= N ||
                    visitedSnake[plusSnakeY][plusSnakeX]) {
                System.out.println(time + 1);
                break;
            }


            //사과가 있는 경우 뱀의 머리를 늘리고, 꼬리는 그대로 유지한다.
            if (dataList[plusSnakeY][plusSnakeX] == 9) {
                dataList[plusSnakeY][plusSnakeX] = 0;
                visitedSnake[plusSnakeY][plusSnakeX] = true;
                snak.addLast(new int[]{plusSnakeX, plusSnakeY});
                //사과가 없는 경우, 뱀의 머리를 늘리고, 꼬리를 줄인다.
            } else {
                //뱀 꼬리
                int[] snakTail = snak.pollFirst();
                visitedSnake[snakTail[1]][snakTail[0]] = false;
                visitedSnake[plusSnakeY][plusSnakeX] = true;
                snak.addLast(new int[]{plusSnakeX, plusSnakeY});
            }


            time += 1;

        }
    }


    private static boolean checkSnakeLocation(int time) {
        if (snakeLocationIndex == snakeLocation.length) {
            return false;
        }

        List<String> dataList = snakeLocation[snakeLocationIndex];
        String snakeTime = dataList.get(0);
        if (Integer.parseInt(snakeTime) == time) {
            String direction = dataList.get(1);
            if (direction.equals("L")) {
                oppositeSnakeLocation((snakeDirection + 2) % 4);
                snakeDirection = (snakeDirection + 3) % 4;
            } else {
                oppositeSnakeLocation((snakeDirection + 2) % 4);
                snakeDirection = (snakeDirection + 1) % 4;
            }
            return true;

        }
        return false;
    }

    private static void oppositeSnakeLocation(int opposite) {
        int oppositeSnakeLocationX = snakeX + direction[opposite][0];
        int oppositeSnakeLocationY = snakeY + direction[opposite][1];

        if (oppositeSnakeLocationX < 0 || oppositeSnakeLocationY < 0 || oppositeSnakeLocationX >= N || oppositeSnakeLocationY >= N) {
            return;
        }

        dataList[oppositeSnakeLocationY][oppositeSnakeLocationX] = 0;
    }

    private static void initSnakeLocationData(BufferedReader br) throws IOException {
        // 뱀 방향
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        snakeLocation = new ArrayList[L];
        for (int i = 0; i < L; i++) {
            snakeLocation[i] = new ArrayList<>(2);
        }

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            String timeX = st.nextToken();
            String direction = st.nextToken();
            snakeLocation[i].add(timeX);
            snakeLocation[i].add(direction);
        }

    }

    private static void initAppleLocationData(BufferedReader br) throws IOException {
        // 사과 위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            dataList[x][y] = 9;
        }
    }
}
