import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dpTable = new int[N+1];

        Arrays.setAll(dpTable, i -> 1);
        for (int a = 1; a < K; a++) {
            for (int i = 1; i < N + 1; i++) {
                dpTable[i] = (dpTable[i] + dpTable[i - 1]) % 1_000_000_000;
            }

        }

        System.out.println(dpTable[N] % 1_000_000_000);
    }
}
