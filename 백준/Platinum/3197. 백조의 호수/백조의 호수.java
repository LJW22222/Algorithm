import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    private static char[][] dataList;
    private static boolean[][] checkList;
    private static boolean[][] swanCheckList;
    private static int A;
    private static int B;
    private static final Queue<int[]> today = new ArrayDeque<>();
    private static final Queue<int[]> todaySwan = new ArrayDeque<>();
    private static final List<int[]> swanLocation = new ArrayList<>();

    private static int day = 0;

    private static final int[][] directionList = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dataList = new char[A][B];
        checkList = new boolean[A][B];
        swanCheckList = new boolean[A][B];

        insertData(bf);

        if (!swanBFS()) {
            BFS();
        }

        System.out.println(day);
    }

    private static void BFS() {
        while (!today.isEmpty()) {
            Queue<int[]> tomorrow = new ArrayDeque<>();
            int size = today.size();
            for (int n = 0; n < size; n++) {
                int[] poll = today.poll();
                int a1 = poll[0];
                int b1 = poll[1];
                meltIce(a1, b1, tomorrow);
            }
            day++;
            if (swanBFS()) break;

            today.addAll(tomorrow);
        }
    }

    private static void meltIce(int a, int b, Queue<int[]> tomorrow) {
        for (int[] ints : directionList) {
            int aa = a + ints[0];
            int bb = b + ints[1];
            if (aa >= A || bb >= B || aa < 0 || bb < 0) continue;

            if (checkList[aa][bb]) continue;

            if ('X' == (dataList[aa][bb])) dataList[aa][bb] = '.';

            tomorrow.add(new int[]{aa,bb});
            checkList[aa][bb] = true;
        }
    }

    private static boolean swanBFS() {
        Queue<int[]> tomorrowSwan = new ArrayDeque<>();
        while (!todaySwan.isEmpty()) {
            int[] poll = todaySwan.poll();
            int a1 = poll[0];
            int b1 = poll[1];

            if (swanLocation.get(1)[0] == a1 && swanLocation.get(1)[1] == b1) {
                return true;
            }

            checkSwanBFS(a1, b1, tomorrowSwan);
        }
        if(!tomorrowSwan.isEmpty())
            todaySwan.addAll(tomorrowSwan);
        return false;
    }

    private static void checkSwanBFS(int a, int b, Queue<int[]> tomorrowSwan) {
        for (int[] ints : directionList) {
            int aa = a + ints[0];
            int bb = b + ints[1];
            if (aa >= A || bb >= B || aa < 0 || bb < 0) continue;

            if (swanCheckList[aa][bb]) continue;

            if('X' == (dataList[aa][bb])) {
                tomorrowSwan.add(new int[]{aa,bb});
            }else if ('.' == (dataList[aa][bb])) {
                todaySwan.add(new int[]{aa,bb});
            }
            swanCheckList[aa][bb] = true;
        }
    }

    private static void insertData(BufferedReader bf) throws IOException {
        for (int i = 0; i < A; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            char[] charDataList = st.nextToken().toCharArray();
            for (int j = 0; j < B; j++) {
                char c = charDataList[j];
                if ('.' == (c)) {
                    today.add(new int[]{i,j});
                    checkList[i][j] = true;
                }
                if ('L' == (c)) {
                    swanLocation.add(new int[]{i,j});
                    checkList[i][j] = true;
                    dataList[i][j] = '.';
                    today.add(new int[]{i,j});
                    continue;
                }
                dataList[i][j] = c;
            }
        }

        todaySwan.add(new int[]{swanLocation.get(0)[0], swanLocation.get(0)[1]});
    }
}
