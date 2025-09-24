import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        int[] dataList = new int[i];
        long[] dpTable = new long[i];

        for (int j = 0; j < i; j++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            dataList[j] = data;
        }

        if (i <= 2) {
            if (i == 1) {
                System.out.println(dataList[0]);
                return;
            } else if (i == 2) {
                System.out.println(dataList[0] + dataList[1]);
                return;
            }
        }

        dpTable[0] = dataList[0];
        dpTable[1] = dataList[0] + dataList[1];
        dpTable[2] = Math.max(Math.max(dpTable[1], dpTable[0] + dataList[2]), dataList[1] + dataList[2]);

        for (int ad = 3; ad < i; ad++) {
            dpTable[ad] = Math.max(Math.max(dpTable[ad - 2] + dataList[ad], dpTable[ad - 1]), dpTable[ad-3] + dataList[ad-1] + dataList[ad]);
        }

        System.out.println(dpTable[i-1]);

    }
}
