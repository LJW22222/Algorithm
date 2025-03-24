import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[][] dataList;
    static boolean[][] visited;
    static String[][] subDataList;

    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dataList = new String[a][b];


        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < b; j++) {
                String s = st.nextToken();
                dataList[i][j] = s;
            }
        }

        subDataList = dataList.clone();

        int count = 0;
        int sum = 0;
        while (true) {
            visited = new boolean[a][b];
            sum = beforeOneHoursCount();
            BFS(0, 0);
            count+=1;
            if (checkBox()) {
                System.out.println(count);
                System.out.println(sum);
                break;
            }
            for (int i = 0; i < a; i++) {
                if (b >= 0) System.arraycopy(subDataList[i], 0, dataList[i], 0, b);
            }
        }
    }

    private static void BFS(int a1, int  b1) {
        if (a1 < 0 || b1 < 0 || a1 >= a || b1 >= b) {
            return;
        }

        if (visited[a1][b1]) {
            return;
        }

        visited[a1][b1] = true;

        if (dataList[a1][b1].equals("1")) {
            subDataList[a1][b1] = "0";
            return;
        }

        BFS(a1+1, b1);
        BFS(a1, b1+1);
        BFS(a1-1, b1);
        BFS(a1, b1-1);
    }

    private static int beforeOneHoursCount() {
        int sum = 0;
        for (String[] strings : dataList) {
            for (String string : strings) {
                if ("1".equals(string)) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private static boolean checkBox() {
        for (String[] booleans : subDataList) {
            for (String s : booleans) {
                if ("1".equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}
