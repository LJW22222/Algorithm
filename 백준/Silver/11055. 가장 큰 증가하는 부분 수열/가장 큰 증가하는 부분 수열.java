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
        int[] dpTable = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            numberList[i] = Integer.parseInt(st.nextToken());
        }

        dpTable[0] = numberList[0];

        for (int j = 1; j < number; j++) {
            int swap = 0;

            for (int z = j; z >= 1; z--) {
                if (numberList[j] > numberList[z - 1]) {
                    swap = Math.max(swap, numberList[j] + dpTable[z - 1]);
                }
            }

            if (swap == 0) swap = numberList[j];

            dpTable[j] = swap;
        }

        int result = 0;
        for (int i = 0; i < number; i++) {
            result = Math.max(result, dpTable[i]);
        }
        System.out.println(result);
    }
}

