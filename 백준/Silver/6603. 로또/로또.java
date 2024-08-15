import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dataList;

    static boolean[] visitedList;

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            st = new StringTokenizer(bf.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            if (i == 0) {
                break;
            }
            dataList = new int[i];
            visitedList = new boolean[i];
            for (int z = 0; z < i; z++) {
                dataList[z] = Integer.parseInt(st.nextToken());
            }

            BackTracking(0, dataList.length, 6, bw);
            System.out.println();


        }
    }

    static void BackTracking(int start, int n, int r, BufferedWriter bw)throws IOException {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visitedList.length; i++) {
                if (visitedList[i]) {
                    sb.append(dataList[i]).append(" ");
                }
            }
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            return;
        }

        for (int i = start; i < n; i++) {
            visitedList[i] = true;
            BackTracking(i+1, n, r-1, bw);
            visitedList[i] = false;
        }



    }
}
