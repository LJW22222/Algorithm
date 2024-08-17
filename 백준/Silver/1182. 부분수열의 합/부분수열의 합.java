import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dataList;
    static boolean[] visitedList;

    static int sum  = 0;
    static int count  = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bu.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dataList = new int[A];
        visitedList = new boolean[A];
        st = new StringTokenizer(bu.readLine());
        for (int i = 0; i < A; i++) {
            dataList[i] = Integer.parseInt(st.nextToken(" "));
        }

        for (int j = 1; j < dataList.length; j++) {
            BackTracking(0, dataList.length, j, B);
        }
        sum = 0;
        for (int j : dataList) {
            sum += j;
        }
        if (sum == B) {
            count++;
        }
        System.out.println(count);


    }

    static void BackTracking(int statNumber, int end, int rr, int B) {

        if (rr == 0) {
            for (int i = 0; i < visitedList.length; i++) {
                if (visitedList[i]) {
                    sum += dataList[i];
                }
            }
            if (sum == B) {
                count++;
            }
            sum = 0;
            return;
        }

        for (int i = statNumber; i < end; i++) {
            visitedList[i] = true;
            BackTracking(i+1, end, rr-1, B);
            visitedList[i] = false;
        }
    }

}
