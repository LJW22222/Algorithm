import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int earth;
    private static int sun;
    private static int moon;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        //1 < 15
        earth = Integer.parseInt(st.nextToken());
        //1 < 28
        sun = Integer.parseInt(st.nextToken());
        // 1 < 19
        moon = Integer.parseInt(st.nextToken());

        check();
    }

    private static void check() {
        int sEarth = 1;
        int sSun = 1;
        int sMoon = 1;
        int count = 1;

        while (true) {
            if (sEarth == earth && sSun == sun && sMoon == moon) {
                System.out.println(count);
                return;
            }

            sEarth++;
            sSun++;
            sMoon++;
            count++;

            if (sEarth > 15) {
                sEarth = 1;
            }

            if (sSun > 28) {
                sSun = 1;
            }

            if (sMoon > 19) {
                sMoon = 1;
            }

        }


    }


}
