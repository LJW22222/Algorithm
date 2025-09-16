import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] buttonList;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int brokenButtonEA = Integer.parseInt(st.nextToken());

        buttonList = new boolean[10];

        if (brokenButtonEA != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < brokenButtonEA; i++) {
                int i1 = Integer.parseInt(st.nextToken());
                buttonList[i1] = true;
            }
        }


        int nowNumber = 100;
        int check1 = Math.abs(target - nowNumber);

        outer:
        for (int i = 0; i <= 1_000_000; i++) {
            String[] s = String.valueOf(i).split("");
            for (String string : s) {
                if (buttonList[Integer.parseInt(string)]) {
                    continue outer;
                }
            }
            int length = s.length;
            int r = Math.abs(target-i);
            check1 = Math.min(check1, (r + length));
        }
        System.out.println(check1);

    }
}
