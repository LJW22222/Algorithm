import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());

        int[] numberList = new int[number];
        long[] dpTable = new long[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        dpTable[0] = 1;

        for (int j = 1; j < number; j++) {
            long count = 1;
            for (int z = j-1; z >= 0; z--) {
                if (numberList[j] < numberList[z]) {
                    count = Math.max(dpTable[z] + 1, count);
                }
            }
            dpTable[j] = count;
        }

        long s = 0;
        for (int a = 0; a < number; a++) {
            s = Math.max(s, dpTable[a]);
        }

        System.out.println(s);
    }
}

