import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static final long NUMBER = 1_000_000_007L;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (B == 0) {
            System.out.println(1);
            return;
        }

        int minus = A - B;

        long a = dp(A, minus);
        long b = dp(B, 0);

        long invB = pow(b, NUMBER - 2);
        long ans = (a % NUMBER) * invB % NUMBER;

        System.out.println(ans);

    }

    private static long dp(int size, int end) {
        long[] dpTable = new long[size+1];
        dpTable[size] = size;

        for (int i = size-1; i > end; i--) {
            dpTable[i] = (dpTable[i+1] * i) % 1_000_000_007;
        }

        return dpTable[end + 1];
    }

    private static long pow(long b, long exp) {
        long result = 1;
        b %= NUMBER;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % NUMBER;
            }
            b = (b * b) % NUMBER;
            exp >>= 1;
        }
        return result;
    }
}
