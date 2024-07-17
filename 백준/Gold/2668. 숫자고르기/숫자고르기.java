import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

    static int[] dataList;

    static boolean[] visitedList;
    static boolean[] dList;

    static int c;

    static ArrayList<Integer> resultList;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        c = Integer.parseInt(st.nextToken());
        dataList = new int[c + 1];
        resultList = new ArrayList<>();

        visitedList = new boolean[c + 1];
        for (int i = 1; i < c + 1; i++) {
            st = new StringTokenizer(in.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            dataList[i] = i1;
        }

        for (int z = 1; z < c + 1; z++) {
            if (!visitedList[z]) {
                dList = new boolean[c+1];
                DFS(z, z);
            }
        }
        System.out.println(count);
        Collections.sort(resultList);
        for (Integer integer : resultList) {
            System.out.println(integer);
        }
    }

    static void DFS(int z, int d) {
        if (visitedList[z]) {
            return;
        }
        visitedList[z] = true;
        dList[z] = true;
        if (dataList[z] == d) {
            for (int i = 0; i < c + 1; i++) {
                if (dList[i]) {
                    count++;
                    resultList.add(i);
                }
            }
            return;
        }
        DFS(dataList[z], d);
        visitedList[z] = false;

    }
}
