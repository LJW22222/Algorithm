import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        int[] dataList = new int[i];
        int[] dpTable = new int[i];

        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < i; j++) {
            dataList[j] = Integer.parseInt(st.nextToken());
        }

        if (i == 1) {
            System.out.println(1);
            return;
        }

        dpTable[0] = 1;
        for (int q = 1; q < i; q++) {
            int j = 1;
            for (int t = q-1; t >= 0; t--) {
                if (dataList[t] < dataList[q]) {
                    j = Math.max(dpTable[t] + 1, j);
                }
            }
            dpTable[q] = j;
        }
        Arrays.sort(dpTable);
        System.out.println(dpTable[i-1]);
    }
}
