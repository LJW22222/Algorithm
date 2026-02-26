import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * robotDirection -> 0 : 북, 1 : 동, 2 : 남, 3 : 서
 */
public class Main {
    /**
     * ints[0] -> y, int[1] -> x
     */
    private static final int[][] directionList = {
            {-1, 0}, // 북
            {0, 1},  // 동
            {1, 0},  // 남
            {0, -1}, // 서
    };

    private static final int[][] backDirectionList = {
            {1, 0}, // 북
            {0, -1},  // 동
            {-1, 0},  // 남
            {0, 1}, // 서
    };

    private static int[][] dataList;
    private static int N;
    private static int M;

    private static int robotX;
    private static int robotY;
    private static int robotDirection;

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //행 -> y
        N = Integer.parseInt(st.nextToken());
        //열 -> X
        M = Integer.parseInt(st.nextToken());


        dataList = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");

        // 행
        robotY = Integer.parseInt(st.nextToken());
        // 열
        robotX = Integer.parseInt(st.nextToken());
        //로봇 방향
        robotDirection = Integer.parseInt(st.nextToken());

        result = 0;

        insertData(br);

        clearLocation();

        System.out.println(result);

    }

    /**
     * 0은 청소되지 않는 칸, 1은 벽, 5는 청소된 칸
     * 조건 1 -> 현재 칸이 아직 청소되지 않는 경우, 현재 칸을 청소한다.
     * 조건 2 -> 현재 칸의 주변 4칸 중, 청소 되지 않는 빈 칸이 없는 경우
     *      2 - 1 -> 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
     *      2 - 2 -> 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
     * 조건 3 -> 현재 칸의 주변 4칸 중 청소되지 않는 빈 칸이 있는 경우
     *      3 - 1 -> 반 시계 방향으로 90도 회전 한다.
     *      3 - 2 -> 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않는 빈 칸인 경우 한 칸 전진한다.
     *      3 - 3 -> 1번으로 돌아간다.
     */
    private static void clearLocation() {

        while (true) {
            if (dataList[robotY][robotX] == 0) {
                dataList[robotY][robotX] = 5;
                result += 1;
            }

            //현재 자리를 기준으로, 주변 4칸을 모두 탐색 한다. 청소되지 않는 부분이 보이면 true, 안보이면 false
            boolean findByAroundClearLocation = findNotClearLocation();

            if (findByAroundClearLocation) {
                rotateRobotLocation();
            } else {
                if (!backRobotLocation()) {
                    return;
                }
            }

        }
    }

    private static void rotateRobotLocation() {
        int plusRobotDirection = (robotDirection + 3) % 4;

        int plusRobotY = robotY + directionList[plusRobotDirection][0];
        int plusRobotX = robotX + directionList[plusRobotDirection][1];

        robotDirection = plusRobotDirection;

        if (plusRobotY < 0 || plusRobotX < 0 || plusRobotY >= N || plusRobotX >= M) return;

        if (dataList[plusRobotY][plusRobotX] == 0) {
            robotX = plusRobotX;
            robotY = plusRobotY;
        }

    }

    private static boolean backRobotLocation() {
        int backY = robotY + backDirectionList[robotDirection][0];
        int backX = robotX + backDirectionList[robotDirection][1];

        if (backY < 0 || backX < 0 || backY >= N || backX >= M || dataList[backY][backX] == 1) {
            return false;
        }

        robotY = backY;
        robotX = backX;

        return true;
    }

    private static boolean findNotClearLocation() {
        for (int[] ints : directionList) {
            int directionY = robotY + ints[0];
            int directionX = robotX + ints[1];

            if (directionY < 0 || directionX < 0 || directionY >= N || directionX >= M) {
                continue;
            }

            if (dataList[directionY][directionX] == 0) {
                return true;
            }

        }
        return false;
    }

    private static void insertData(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                dataList[i][j] = number;
            }
        }
    }


}
