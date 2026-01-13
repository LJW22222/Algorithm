import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    private static int N;
    private static int K;
    private static int[][] dpTable;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(sc.nextLine());
        K = Integer.parseInt(st.nextToken());

        if (K > N / 2) {
            System.out.println(0);
            return;
        }


        int dp1 = dp1();
        int dp2 = dp2();
        System.out.println((dp1 + dp2) % 1_000_000_003);
    }

    private static int dp1() {
        int S = N - 3;
        int SK = K - 1;
        dpTable = new int[S + 1][SK + 1];
        for (int i = 0; i < S + 1; i++) {
            dpTable[i][0] = 1;
        }
        if (SK + 1 >= 2) {
            dpTable[1][1] = 1;
        }
        for (int j = 1; j < SK + 1; j++) {
            for (int i = 1; i < S + 1; i++) {
                if (j > (i + 1) / 2) {
                    continue;
                }
                dpTable[i][j] = (dpTable[i][j] + dpTable[i - 1][j] ) % 1_000_000_003;
                if (i >= 2) {
                    dpTable[i][j] = (dpTable[i][j] + dpTable[i - 2][j - 1]) % 1_000_000_003;
                }
            }
        }
        return dpTable[S][SK] % 1_000_000_003;
    }

    private static int dp2() {
        dpTable = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            dpTable[i][0] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (j > (i + 1) / 2) {
                    continue;
                }
                dpTable[i][j] = (dpTable[i][j] + dpTable[i - 1][j] ) % 1_000_000_003;
                if (i >= 2) {
                    dpTable[i][j] = (dpTable[i][j] + dpTable[i - 2][j - 1]) % 1_000_000_003;
                }
            }
        }

        return dpTable[N][K] % 1_000_000_003;
    }

}
