import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dataList;
    private static int[][] firstData;
    private static long B;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dataList = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        firstData = new int[N][N];
        for (int i = 0; i < N; i++) firstData[i][i] = 1;

        long middle = B;
        while (middle > 0) {
            if (middle % 2 == 1) {
                firstData = dataMultiply(firstData, dataList);
            }
            dataList = dataMultiply(dataList, dataList);

            middle /= 2;
        }

        for (int[] ints : firstData) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    private static int[][] dataMultiply(int[][] A, int[][] B) {
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int S = 0;
                for (int k = 0; k < N; k++) {
                        S += A[i][k] * B[k][j] % 1000;
                }
                C[i][j] = S % 1000;
            }
        }
        return C;
    }


}
