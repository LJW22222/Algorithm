import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        gcd(a,b);
        bw.flush();
    }

    private static void gcd(Long a, Long b) throws IOException {
        if (a % b == 0) {
            for (int i = 0; i < b; i++) {
                bw.append("1");
            }
            return;
        }
        gcd(b, a%b);
    }
}
