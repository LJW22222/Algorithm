import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());

        int[] dataList = new int[number];
        int[] dpTable = new int[number];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < number; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        dpTable[0] = dataList[0];

        for (int j = 1; j < number; j++) {
            dpTable[j] = dpTable[j - 1] > 0 ? dpTable[j - 1] + dataList[j] : dataList[j];
        }

        int result = dpTable[0];
        for (int j = 1; j < number; j++) {
            result = Math.max(result, dpTable[j]);
        }
        System.out.println(result);
    }
}

