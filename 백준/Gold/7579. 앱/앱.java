import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * S의 앱을 종료하여 M이상의 메모리 바이트를 확보 하는 문제
 * 단, 비용C(cost)를 최소하여 찾아야 함. => 최소값 구하는 문제
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st1.nextToken());
        }

        int[] dpTable = new int[100000];

        for (int i = 0; i < N; i++) {
            for (int j = dpTable.length - 1; j >= cost[i]; j--) {
                dpTable[j] = Math.max(dpTable[j], dpTable[j - cost[i]] + memory[i]);
            }
        }

        for (int j = 0; j < dpTable.length - 1; j++) {
            if (dpTable[j] >= M) {
                System.out.println(j);
                return;
            }
        }

    }
}
