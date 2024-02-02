import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum;
        st = new StringTokenizer(in.readLine());
        int[] result = new int[A+1];
        for (int j = 1; j <= A; j++) {
            result[j] = result[j - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            sum = result[l] - result[c-1];
            System.out.println(sum);
        }
    }
}