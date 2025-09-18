import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] cost;
    private static boolean[] visited;
    private static int number;
    private static List<Integer> resultList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        number = Integer.parseInt(st.nextToken());


        visited = new boolean[number];

        cost = new int[number][number];
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < number; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] cityNumbers = new int[number];
        for (int i = 0; i < number; i++) {
            visited[i] = true;
            cityNumbers[0] = i;
            goingCity(1, cityNumbers);
        }
        System.out.println(Collections.min(resultList));
    }

    private static void goingCity(int nowNumber, int[] cityNumbers) {
        if (nowNumber == number) {
            int sum = 0;
            int lastEnd = 0;
            for (int i = 0; i < number-1; i++) {
                int start = cityNumbers[i];
                int end = cityNumbers[i + 1];
                if (cost[start][end] == 0) {
                    return;
                }
                sum += cost[start][end];
                lastEnd = end;
            }
            if (cost[lastEnd][0] == 0) {
                return;
            }
            sum += cost[lastEnd][0];
            resultList.add(sum);
            return;
        }

        for (int i = 0; i < number; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cityNumbers[i] = nowNumber;
                goingCity(nowNumber + 1, cityNumbers);
                visited[i] = false;
            }
        }

    }
}
