import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        long[][] dpTable = new long[N][N];
        int[] dataList = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        dataList[0] = Integer.parseInt(st.nextToken());
        dataList[1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int pass = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());
            dataList[i + 1] = input;
        }

        for (int z = 0; z < N; z++) {
            for (int i = 0; i + z < N; i++) {
                int j = i + z;

                if (z == 1) {
                    dpTable[i][j] = (long) dataList[i + 1] * dataList[i] * dataList[j + 1];
                    continue;
                }

                for (int c = i; c < j; c++) {
                    if (dpTable[i][j] != 0) {
                        dpTable[i][j] = Math.min(dpTable[i][j], dpTable[i][c] + dpTable[c + 1][j] + (long) dataList[i] * dataList[j + 1] * dataList[c + 1]);
                    } else {
                        dpTable[i][j] = dpTable[i][c] + dpTable[c + 1][j] + (long) dataList[i] * dataList[j + 1] * dataList[c + 1];
                    }

                }
            }
        }

        System.out.println(dpTable[0][N - 1]);
    }
}
