import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] dataList;
    private static boolean[] visitedList;
    private static int[] checkList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        dataList = new List[a+1];
        checkList = new int[a + 1];
        for (int i = 0; i < a + 1; i++) {
            dataList[i] = new ArrayList<>();
        }

        visitedList = new boolean[a + 1];
        for (int i = 0; i < a - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());

            dataList[i1].add(j1);
            dataList[j1].add(i1);
        }

        DFS(1, 1);

        for (int i : checkList) {
            if (i != 0) {
                bw.append(String.valueOf(i)).append("\n");
            }
        }
        bw.flush();
    }

    private static void DFS(int number, int n) {
        if (visitedList[number]) {
            checkList[n] = number;
            return;
        }
        visitedList[number] = true;
        for (Integer numbers : dataList[number]) {
            DFS(numbers, number);
        }
    }
}
