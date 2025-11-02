import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int[] dataList;
    private static int K;
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            dataList = new int[K];
            sum = new int[K + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                dataList[j] = Integer.parseInt(st.nextToken());
            }

            for (int a = 1; a <= K; a++) {
                sum[a] = sum[a - 1] + dataList[a-1];
            }

            int[][] dpTable = new int[K + 1][K + 1];

            fileMerge(dpTable);

            bw.append(String.valueOf(dpTable[1][K])).append("\n");
        }

        bw.flush();
    }

    private static void fileMerge(int[][] dpTable) {
        for (int k = 2; k <= K; k++) {
            for (int i = 1; i + k - 1 <= K; i++) {
                int q = i + k - 1;
                for (int j = i; j < q; j++) {
                    int result;
                    if (k == 2) {
                        result = sum[q] - sum[i-1];
                    } else {
                        if (dpTable[i][q] == 0) {
                            result = dpTable[i][j] + dpTable[j + 1][q] + (sum[q] - sum[i-1]);
                        } else {
                            result = Math.min(dpTable[i][q], dpTable[i][j] + dpTable[j + 1][q] + (sum[q] - sum[i-1]));
                        }
                    }
                    dpTable[i][q] = result;
                }
            }
        }
    }
}
