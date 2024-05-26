import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] visitedList;

    static int count = 1;

    static int X;
    static int Y;

    static int[][] dataList;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        X = Integer.parseInt(st.nextToken()) + 2;
        Y = Integer.parseInt(st.nextToken()) + 2;
        visitedList = new boolean[X][Y];
        dataList = new int[X][Y];
        for (int i = 1; i < X-1; i++) {
            st = new StringTokenizer(in.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 1; j < Y-1; j++) {
                if (split[j - 1].equals("1")) {
                    dataList[i][j] = 1;
                } else {
                    dataList[i][j] = 0;
                }
            }
        }
        BFS(1, 1);
        System.out.println(count);
    }

    static void BFS(int x, int y) {
        visitedList[x][y] = true;
        Queue<Integer> XQu = new LinkedList<>();
        Queue<Integer> YQu = new LinkedList<>();
        ArrayList<Integer> XList = new ArrayList<>();
        ArrayList<Integer> YList = new ArrayList<>();
        XQu.add(x);
        YQu.add(y);
        int poll = 0;
        int poll1 = 0;
        while (!visitedList[X-2][Y-2]) {
            XList.clear();
            YList.clear();
            count++;
            while (!XQu.isEmpty() && !YQu.isEmpty()) {
                poll = XQu.poll();
                poll1 = YQu.poll();
                if (!visitedList[poll][poll1 + 1] && dataList[poll][poll1 + 1] == 1) {
                    visitedList[poll][poll1 + 1] = true;
                    XList.add(poll);
                    YList.add(poll1 + 1);
                }
                if (dataList[poll][poll1 - 1] == 1 && !visitedList[poll][poll1 - 1]) {
                    visitedList[poll][poll1 - 1] = true;
                    XList.add(poll);
                    YList.add(poll1 - 1);
                }
                if (dataList[poll + 1][poll1] == 1 && !visitedList[poll + 1][poll1]) {
                    visitedList[poll + 1][poll1] = true;
                    XList.add(poll + 1);
                    YList.add(poll1);
                }
                if (dataList[poll - 1][poll1] == 1 && !visitedList[poll - 1][poll1]) {
                    visitedList[poll - 1][poll1] = true;
                    XList.add(poll - 1);
                    YList.add(poll1);
                }
            }
            XQu.addAll(XList);
            YQu.addAll(YList);
        }
    }
}
