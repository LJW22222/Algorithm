import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long i = sc.nextLong();
        if (i == 0) {
            System.out.println(0);
            return;
        }
        avg(i);
        System.out.println(sb.reverse());
    }

    private static void avg(long i){
        long r = i % -2;
        long q = i / -2;
        if (i == 0) {
            return;
        }

        if (r < 0) {
            q += 1;
            r += 2;
        }
        sb.append(r);
        avg(q);
    }
}
