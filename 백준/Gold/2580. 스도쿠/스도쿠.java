
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] list = new int[9][9];
    private static final ArrayList<int[]> zeroList = new ArrayList<>();

    private static final int[] numberList = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                if (i1 == 0) {
                    zeroList.add(new int[]{i, j});
                }
                list[i][j] = i1;
            }
        }

        backTracking(0);

    }

    private static boolean backTracking(int i) {
        if (i >= zeroList.size()) {
            for (int resultY = 0; resultY < 9; resultY++) {
                for (int resultX = 0; resultX < 9; resultX++) {
                    System.out.print(list[resultY][resultX] + " ");
                }
                System.out.println();
            }
            return true;
        }

        for (int i1 : numberList) {
            int[] ints = zeroList.get(i);
            int y = ints[0];
            int x = ints[1];

            if (checkingNumber(y, x ,i1)) {
                list[y][x] = i1;
                if (backTracking(i + 1)) {
                    return true;
                }
                list[y][x] = 0;
            }
        }
        return false;
    }

    private static boolean checkingNumber(int y, int x, int i1) {
        //Box Size
        int startY = y / 3 * 3;
        int startX = x / 3 * 3;
        for (int z = 0; z < 9; z++) {
            if (list[y][z] == i1) {
                return false;
            }
            if (list[z][x] == i1) {
                return false;
            }
        }

        for (int sy = startY; sy < startY + 3; sy++) {
            for (int sx = startX; sx < startX + 3; sx++) {
                if (list[sy][sx] == i1) {
                    return false;
                }
            }
        }

        return true;
    }
}
