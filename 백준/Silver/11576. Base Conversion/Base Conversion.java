import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int B;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());

        long sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        long b;
        for (int i = C-1; i >= 0; i--) {
            int i1 = Integer.parseInt(st.nextToken());
            if (i == 0) {
                b = i1;
            } else {
                b =  (long)Math.pow(A, i) * i1;
            }
            sum += b;
        }
        recursion(sum);
        bw.flush();
    }

    public static void recursion(long sum) throws IOException {
        if (sum == 0) {
            return;
        }

        long i = sum % B;

        recursion(sum / B);
        bw.append(String.valueOf(i)).append(" ");
    }
}

