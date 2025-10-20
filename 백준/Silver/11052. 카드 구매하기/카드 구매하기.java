import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        int[] dataList = new int[i + 1];
        int[] dpTable = new int[i + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 1; j < i+ 1; j++) {
            dataList[j] = Integer.parseInt(st.nextToken());
        }
        dpTable[0] = 0;
        for (int n = 1; n < i + 1; n++) {
            int result = dpTable[n] * i;
            for (int z = 1; z < n + 1; z++) {
                result = Math.max(result, dpTable[n - z] + dataList[z]);
            }
            dpTable[n] = result;
        }

        System.out.println(dpTable[i]);
    }
}
