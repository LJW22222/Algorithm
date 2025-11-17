import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dataList = new int[N];
        int[][] dpTable = new int[N][N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            dpTable[i][i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            dpTable[i][i + 1] = dataList[i] == dataList[i + 1] ? 1 : 0;
        }

        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                dpTable[j][j + i] = dpTable[j + 1][j + i - 1] == 1 && dataList[j] == dataList[j + i] ? 1 : 0;
            }
        }


        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (dpTable[a][b] == 1) {
                bw.append("1").append("\n");
            } else {
                bw.append("0").append("\n");
            }
        }
        bw.flush();
    }
}
