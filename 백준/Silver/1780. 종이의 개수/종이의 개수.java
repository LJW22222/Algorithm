import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dataList;
    private static int A;
    private static int zero = 0;
    private static int minus = 0;
    private static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());

        dataList = new int[A][A];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < A; j++) {
                dataList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dataListPow(0, 0, A);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void dataListPow(int startX, int startY, int size) {
        if (startX > A || startY > A) {
            return;
        }
        if (checkDataList(startX, startY, size)) {
            if (dataList[startY][startX] == 0) {
                zero +=1;
            } else if (dataList[startY][startX] == 1) {
                plus +=1;
            } else {
                minus +=1;
            }
            return;
        }
        int newSize = size;
        if (size != 1) {
            newSize = size / 3;
        }
        for (int i = startY; i < startY + size; i+= newSize) {
            for (int j = startX; j < startX + size; j+= newSize) {
                dataListPow(j, i, newSize);
            }
        }
    }

    private static boolean checkDataList(int startX, int startY, int size) {
        int checkNumber = dataList[startY][startX];
        for (int y = startY; y < startY + size; y++) {
            for (int x = startX; x < startX + size; x++) {
                if (dataList[y][x] != checkNumber) {
                    return false;
                }
            }
        }
        return true;
    }
}
