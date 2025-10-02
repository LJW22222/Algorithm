import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int dataSize = Integer.parseInt(st.nextToken());
            long[] dptTable = new long[dataSize];
            if (insertData(dataSize, dptTable)) {
                bw.append(String.valueOf(dptTable[dataSize - 1])).append("\n");
                continue;
            }
            for (int a = 5; a < dataSize; a++) {
                dptTable[a] = dptTable[a - 5] + dptTable[a - 1];
            }

            bw.append(String.valueOf(dptTable[dataSize - 1])).append("\n");
        }

        bw.flush();
    }

    private static boolean insertData(int dataSize, long[] dpTable) {
        if (dataSize == 1) {
            dpTable[0] = 1;
            return true;
        }
        if (dataSize == 2) {
            dpTable[0] = 1;
            dpTable[1] = 1;
            return true;
        }
        if (dataSize == 3) {
            dpTable[0] = 1;
            dpTable[1] = 1;
            dpTable[2] = 1;
            return true;
        }
        if (dataSize == 4) {
            dpTable[0] = 1;
            dpTable[1] = 1;
            dpTable[2] = 1;
            dpTable[3] = 2;
            return true;
        }
        dpTable[0] = 1;
        dpTable[1] = 1;
        dpTable[2] = 1;
        dpTable[3] = 2;
        dpTable[4] = 2;
        return false;
    }
}

