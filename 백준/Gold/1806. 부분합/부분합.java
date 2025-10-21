import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int S;
    private static int N;
    private static int[] dataList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        dataList = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            dataList[i] = Integer.parseInt(st.nextToken());
        }

        int point = toPoint();
        System.out.println(point);
    }

    private static int toPoint() {

        int sum = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;

        while (left <= right) {
            if (sum < S) {
                if (right >= N) {
                    break;
                }
                sum += dataList[right];
                right += 1;
                count +=1;
            } else {
                if (left >= N) {
                    break;
                }
                if (result != 0) {
                    result = Math.min(result, count);
                }
                if (result == 0) {
                    result = count;
                }

                sum -= dataList[left];
                left += 1;
                count -=1;
            }
        }

        return result;
    }
}