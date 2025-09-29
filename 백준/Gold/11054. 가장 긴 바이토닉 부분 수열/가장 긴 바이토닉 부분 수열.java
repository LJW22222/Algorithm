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
        int[] dataList = new int[number];
        int[] dpTableDown = new int[number];
        int[] dpTableUp = new int[number];
        int[] bitonic = new int[number];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < number; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        bitonic[0] = 1;
        dpTableUp[0] = 1;
        dpTableDown[number-1] = 1;

        for (int i = 1; i < number; i++) {
            dpTableUp[i] = 1;
            for (int a = 0; a < i; a++) {
                if (dataList[a] < dataList[i]) {
                    dpTableUp[i] = Math.max(dpTableUp[a] + 1, dpTableUp[i]);
                }
            }
        }

        for (int i = number - 1; i >= 0; i--) {
            dpTableDown[i] = 1;
            for (int a = i + 1; a < number; a++) {
                if (dataList[a] < dataList[i]) {
                    dpTableDown[i] = Math.max(dpTableDown[a] + 1, dpTableDown[i]);
                }
            }

        }

        for (int i = 0; i < number; i++) {
            bitonic[i] = dpTableUp[i] + dpTableDown[i];
        }

        int result = 0;
        for (int i : bitonic) {
            result = Math.max(i, result);
        }

        System.out.println(result-1);

    }
}
