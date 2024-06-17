import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int A;
    static int B;

    static int[][] dataList;
    static int[][] subList;

    static boolean[][] visitedList;

    static int count = 1;

    static int years = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dataList = new int[A][B];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < B; j++) {
                int c = Integer.parseInt(st.nextToken());
                dataList[i][j] = c;
            }
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                years++;
                subList = new int[A][B];
                visitedList = new boolean[A][B];
                DFS(i, j);
                dff();
                count = 0;
                visitedList = new boolean[A][B];
                for (int c = 0; c < A; c++) {
                    for (int bb = 0; bb < B; bb++) {
                        if (!visitedList[c][bb] && dataList[c][bb] > 0) {
                            DFS2(c, bb);
                            if (dataList[c][bb] != 0) {
                                count++;

                            }
                        }
                    }
                }

                if (count >= 2) {
                    break;
                }
            }
            if (count >= 2) {
                break;
            }
        }
        if (count >= 2) {
            System.out.println(years);
        } else {
            System.out.println(0);
        }

    }

    static void dff() {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                dataList[i][j] += subList[i][j];
                if (dataList[i][j] < 0) {
                    dataList[i][j] = 0;
                }
            }
        }
    }

    static void DFS2(int a, int b) {
        if (a < 0 || b < 0 || a > A - 1 || b > B - 1) {
            return;
        }
        if (visitedList[a][b]) {
            return;
        }
        if (dataList[a][b] == 0) {
            return;
        }

        visitedList[a][b] = true;

        DFS2(a, b - 1);
        DFS2(a, b + 1);
        DFS2(a - 1, b);
        DFS2(a + 1, b);
    }

    static void DFS(int a, int b) {
        if (a < 0 || b < 0 || a > A - 1 || b > B - 1) {
            return;
        }
        if (visitedList[a][b]) {
            return;
        }

        if (dataList[a][b] > 0) {
            if (dataList[a + 1][b] == 0) {
                subList[a][b] -= 1;
            }
            if (dataList[a - 1][b] == 0) {
                subList[a][b] -= 1;
            }
            if (dataList[a][b + 1] == 0) {
                subList[a][b] -= 1;
            }
            if (dataList[a][b - 1] == 0) {
                subList[a][b] -= 1;
            }

        }
        visitedList[a][b] = true;
        DFS(a, b - 1);
        DFS(a, b + 1);
        DFS(a - 1, b);
        DFS(a + 1, b);
    }


}