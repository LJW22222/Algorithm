import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] dataList;
    private static int A;
    private static int B;
    private static int C;
    private static int[][][] dpTable;

    private static final int[][] nodeStatus = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        dataList = new char[A][B];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String s = st.nextToken();
            char[] charArray = s.toCharArray();
            System.arraycopy(charArray, 0, dataList[i], 0, B);
        }

        st = new StringTokenizer(br.readLine(), "");
        String result = st.nextToken();
        dpTable = new int[A][B][result.length()];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                Arrays.fill(dpTable[i][j], -1);
            }
        }

        char[] resultChar = result.toCharArray();
        int result2 = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (dataList[i][j] == resultChar[0]) {
                    result2 += DFS(i, j, 0, resultChar);
                }
            }
        }
        System.out.println(result2);

    }

    private static int DFS(int inputA, int inputB, int location, char[] resultChar) {
        if (dpTable[inputA][inputB][location] != -1) {
            return dpTable[inputA][inputB][location];
        }

        if (dataList[inputA][inputB] != resultChar[location]) {
            dpTable[inputA][inputB][location] = 0;
            return  0;
        }

        if (location == resultChar.length - 1) {
            dpTable[inputA][inputB][location] = 1;
            return 1;
        }

        int sum = 0;
        for (int q = 1; q <= C; q++) {
            for (int[] status : nodeStatus) {
                int statusA = inputA + status[0] * q;
                int statusB = inputB + status[1] * q;

                if (statusA >= A || statusB >= B || statusA < 0 || statusB < 0) {
                    continue;
                }

                if (resultChar[location+1] == dataList[statusA][statusB]) {
                    sum += DFS(statusA, statusB, location + 1, resultChar);
                }
            }
        }
        dpTable[inputA][inputB][location] = sum;
        return dpTable[inputA][inputB][location];
    }
}
