import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());


        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            long[][] dataList = new long[2][b];
            long[][] dpTable = new long[2][b];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int jj = 0; jj < b; jj++) {
                    int i1 = Integer.parseInt(st.nextToken());
                    dataList[j][jj] = i1;
                }
            }

            dpTable[0][0] = dataList[0][0];
            dpTable[1][0] = dataList[1][0];
            int ac = 1;
            while (ac != b) {
                dpTable[0][ac] = ((ac >= 2) ? Math.max(dpTable[1][ac-1], dpTable[1][ac-2]) : dpTable[1][ac-1]) + dataList[0][ac];
                dpTable[1][ac] = ((ac >= 2) ? Math.max(dpTable[0][ac-1], dpTable[0][ac-2]) : dpTable[0][ac-1]) + dataList[1][ac];
                ac++;
            }
            bw.append(String.valueOf(Math.max(dpTable[0][b - 1], dpTable[1][b - 1]))).append("\n");
        }
        bw.flush();
    }
}

