import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//urL
public class Main {

    private static int[] startPoint = new int[2];
    private static int[] nowPoint = new int[3];

    // 0-> 위, 1-> 오른, 2-> 아래, 3-> 왼
    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int[] dx = new int[]{0, 1, 0, -1};


    private static int XX;
    private static int YY;
    private static char[][] dataList;

    private static char[] charList = new char[]{'+', '-', '|', '1', '2', '3', '4'};


    private static int[][] directionNumberLits = new int[128][4];
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        for (int[] directionNumberLit : directionNumberLits) {
            Arrays.fill(directionNumberLit, -1);
        }

        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        YY = Integer.parseInt(st.nextToken());
        XX = Integer.parseInt(st.nextToken());

        dataList = new char[YY][XX];

        for (int i = 0; i < YY; i++) {
            st = new StringTokenizer(br.readLine());
            char[] charArray = st.nextToken().toCharArray();
            for (int j = 0; j < XX; j++) {
                char c = charArray[j];
                checkData(c, i, j);
                dataList[i][j] = c;
            }
        }

        going();
    }


    private static void going() {
        int y = startPoint[0];
        int x = startPoint[1];
        directionDesignation(y, x);

        int addY = nowPoint[0];
        int addX = nowPoint[1];
        int direction = nowPoint[2];

        // 0-> 위, 1-> 오른, 2-> 아래, 3-> 왼
        while (true) {
            if (dataList[addY][addX] == '.') {
                break;
            }
            char c = dataList[addY][addX];

            direction = directionNumberLits[c][direction];

            addY = addY + dy[direction];
            addX = addX + dx[direction];

            if (checkLine(addY, addX)) {
                break;
            }

        }

        sb.append(addY + 1).append(" ").append(addX + 1).append(" ");

        searchPipe(direction, addX, addY);

        System.out.println(sb.toString());
    }

    private static void searchPipe(int direction, int addX, int addY) {
        for (char c : charList) {
            if (directionNumberLits[c][direction] != -1) {
                if (c == '+') {
                    boolean s = false;
                    for (int z = 0; z < 4; z++) {
                        int aXX1 = addX + dx[z];
                        int aYY1 = addY + dy[z];

                        if (checkLine(aYY1, aXX1) || directionNumberLits[dataList[aYY1][aXX1]][z] == -1) {
                            s = true;
                            break;
                        }
                    }
                    if (!s) {
                        sb.append(c);
                        return;
                    }
                } else {
                    int i = directionNumberLits[c][direction];
                    int aXX = addX + dx[i];
                    int aYY = addY + dy[i];
                    if (checkLine(aYY, aXX)) {
                        continue;
                    }

                    if (dataList[aYY][aXX] != '.') {
                        if (directionNumberLits[dataList[aYY][aXX]][i] != -1) {
                            sb.append(c);
                        }
                    }
                }
            }
        }
    }

    private static void directionDesignation(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int addY = y + dy[i];
            int addX = x + dx[i];
            if (checkLine(addY, addX)) {
                continue;
            }
            if (dataList[addY][addX] != '.') {
                char c = dataList[addY][addX];
                if (directionNumberLits[c][i] == -1) continue;
                nowPoint[0] = addY;
                nowPoint[1] = addX;
                nowPoint[2] = i;
                return;
            }
        }
    }

    private static boolean checkLine(int y, int x) {
        return y >= YY || x >= XX || y < 0 || x < 0;
    }


    private static void checkData(char c, int y, int x) {
        if (c == 'M') {
            startPoint[0] = y;
            startPoint[1] = x;
        }
    }

    private static void init() {
        // 0-> 위, 1-> 오른, 2-> 아래, 3-> 왼
        directionNumberLits['|'][2] = 2;
        directionNumberLits['|'][0] = 0;

        directionNumberLits['-'][3] = 3;
        directionNumberLits['-'][1] = 1;


        directionNumberLits['+'][0] = 0;
        directionNumberLits['+'][2] = 2;
        directionNumberLits['+'][1] = 1;
        directionNumberLits['+'][3] = 3;


        directionNumberLits['1'][0] = 1;
        directionNumberLits['1'][3] = 2;


        directionNumberLits['2'][2] = 1;
        directionNumberLits['2'][3] = 0;


        directionNumberLits['3'][1] = 0;
        directionNumberLits['3'][2] = 3;


        directionNumberLits['4'][1] = 2;
        directionNumberLits['4'][0] = 3;
    }
}
