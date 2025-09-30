import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());

        int[] dataList = new int[number];
        int[][] dpTable = new int[number][2];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            dataList[i] = data;
        }

        dpTable[0][0] = dataList[0];
        dpTable[0][1] = -1;
        if (number == 1) {
            System.out.println(dpTable[0][0]);
            return;
        }
        dpTable[1][0] = dataList[1];
        dpTable[1][1] = dpTable[0][0] + dataList[1];
        if (number == 2) {
            System.out.println(Math.max(dpTable[1][0], dpTable[1][1]));
            return;
        }

        for (int a = 0; a < number; a++) {
            if (dpTable[a][0] != -1) {
                if (a+1 < number) {
                    dpTable[a + 1][1] = Math.max(dpTable[a + 1][1], dpTable[a][0] + dataList[a + 1]);
                }

                if (a+2 < number) {
                    dpTable[a+2][0] = Math.max(dpTable[a+2][0], dpTable[a][0] + dataList[a+2]);
                }
            }

            if (dpTable[a][1] != -1) {
                if (a+2 < number) {
                    dpTable[a+2][0] = Math.max(dpTable[a+2][0], dpTable[a][1] + dataList[a+2]);
                }
            }
        }

        System.out.println(Math.max(dpTable[dpTable.length-1][0], dpTable[dpTable.length-1][1]));

    }
}

