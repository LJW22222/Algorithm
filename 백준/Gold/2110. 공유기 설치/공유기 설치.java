import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Integer[] dataList;
    private static long b;
    private static ArrayList<Long> da = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dataList = new Integer[a];

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            dataList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dataList);
        checkRouter();
        System.out.println(Collections.max(da));
    }

    private static void checkRouter() {
        long left = 1;
        long right = dataList[dataList.length-1] - dataList[0];
        long result = 0;
        while (left <= right) {
            long mide = (left + right) / 2;
            if (checkHomeDistance(mide)) {
                da.add(mide);
                left = mide + 1;
            } else {
                right = mide - 1;
            }

        }
    }

    private static boolean checkHomeDistance(long mid) {
        int count = 1;
        int start = dataList[0];
        for (int i = 1; i < dataList.length; i++) {
            int tt = dataList[i] - start;
            if (tt >= mid) {
                start = dataList[i];
                count += 1;
            }
        }
        return b <= count;
    }
}
