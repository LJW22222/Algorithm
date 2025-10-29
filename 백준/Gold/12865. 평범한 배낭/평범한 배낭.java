import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<int[]> dataList = new ArrayList<>();
        int[][] dpTable = new int[A + 1][R+ 1];

        dataList.add(new int[]{});
        for (int i = 1; i < A + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            dataList.add(new int[]{W, V});
        }

        dpTable[0][0] = 0;

        //dp 물건 갯수
        for (int i = 1; i < A + 1; i++) {
            int[] ints = dataList.get(i);
            //무게 Input
            int W = ints[0];
            //가치 Input
            int V = ints[1];
            //dp 물건 무개
            for (int j = 0; j < R + 1; j++) {
                if (j < W) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i - 1][j - W] + V);
                }
            }
        }


        System.out.println(dpTable[A][R]);
    }

}
