import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int girl = Integer.parseInt(st.nextToken());
        int man = Integer.parseInt(st.nextToken());
        int team = Integer.parseInt(st.nextToken());

        int t = min(girl / 2, man);
        int eM = girl + man - 3 * t;
        while (eM - team < 0) {
            eM += 3;
            t -= 1;
        }
        System.out.println(t);
    }
}
