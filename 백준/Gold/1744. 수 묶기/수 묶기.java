import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] buttonList;
    private static int target;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] dataList = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortDataList = Arrays.stream(dataList, 0, dataList.length - 1)
                .boxed()
                .sorted((a, b) -> {
                    if (a < 0 && b < 0) return Integer.compare(a, b);

                    if (a > 0 && b > 0) return Integer.compare(b, a);

                    return Integer.compare(a, b);
                })
                .mapToInt(Integer::intValue)
                .toArray();

        int i = 0;
        while (i + 1 < N) {
            int i1 = sortDataList[i];
            int i2 = sortDataList[i + 1];

            //앞에 숫자가 음수인 경우
            if (i1 < 0) {
                if (i2 <= 0) {
                    result += i1 * i2;
                    i += 2;
                }
                if (i2 > 0) {
                    result += i1;
                    i += 1;
                }
                //앞에 숫자가 양수인 경우
            } else if (i1 > 0) {
                //앞에 숫자가 0이나 1인 경우
                if (i2 == 0 || i2 == 1) {
                    result += i1 + i2;
                    i += 2;
                }
                //양수
                if (i2 > 1) {
                    result += i1 * i2;
                    i += 2;
                }
                //앞에 숫자가 0인 경우
            } else {
                //양수
                if (i2 > 0) {
                    i += 1;
                }

                if (i2 == 0) {
                    i += 2;
                }
            }
        }

        if (i != N) {
            result += sortDataList[N-1];
        }
        System.out.println(result);

    }
}
