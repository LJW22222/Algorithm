import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visitedList;

    static int[][] dataList;

    static int i1;
    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bu.readLine());
        i1 = Integer.parseInt(st.nextToken());
        dataList = new int[i1][2];
        for (int i = 0; i < i1; i++) {
            st = new StringTokenizer(bu.readLine());
            dataList[i][0] = Integer.parseInt(st.nextToken());
            dataList[i][1] = Integer.parseInt(st.nextToken());
        }
        visitedList = new boolean[i1];
        BackTraking(0, 1, 0, 0);
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static void BackTraking(int index, int sourProduct, int bitterSum, int count) {
        if (index == i1) {
            if (count > 0) {
                list.add(Math.abs(sourProduct - bitterSum));
            }
            return;
        }
        BackTraking(index + 1, sourProduct * dataList[index][0], bitterSum + dataList[index][1], count + 1);
        BackTraking(index + 1, sourProduct, bitterSum, count);
    }
}
